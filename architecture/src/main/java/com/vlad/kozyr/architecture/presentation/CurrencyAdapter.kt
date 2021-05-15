package com.vlad.kozyr.architecture.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vlad.kozyr.architecture.databinding.ExchangeRateItemBinding
import com.vlad.kozyr.architecture.domain.model.Currency


class CurrencyAdapter :
    ListAdapter<Currency, CurrencyAdapter.CurrencyHolder>(CurrencyDiffCallback()) {

    class CurrencyHolder(private val binding: ExchangeRateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency) {
            binding.currency = currency
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CurrencyHolder(ExchangeRateItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
    }
}

class CurrencyDiffCallback : DiffUtil.ItemCallback<Currency>() {

    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean =
        oldItem.name == newItem.name
}
