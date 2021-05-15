package com.vlad.kozyr.architecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vlad.kozyr.architecture.domain.model.Currency
import com.vlad.kozyr.architecture.domain.usecase.FetchCurrencyUseCase
import com.vlad.kozyr.architecture.domain.usecase.GetCurrenciesUseCase
import com.vlad.kozyr.architecture.presentation.model.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class CurrencyViewModel(
    getCurrenciesUseCase: GetCurrenciesUseCase,
    private val fetchCurrencyUseCase: FetchCurrencyUseCase
) : ViewModel() {

    private val _state = MutableLiveData<UiState>()
    val state: LiveData<UiState>
        get() = _state

    private val _currencies = getCurrenciesUseCase.execute()
    val currencies: LiveData<List<Currency>>
        get() = _currencies

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _state.postValue(UiState.Loading)
                fetchCurrencyUseCase.execute()
                _state.postValue(UiState.Completed)
            } catch (ex: Exception) {
                _state.postValue(UiState.Error(ex.message ?: "Cannot update"))
            }
        }
    }
}