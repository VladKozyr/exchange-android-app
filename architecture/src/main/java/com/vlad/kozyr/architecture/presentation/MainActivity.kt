package com.vlad.kozyr.architecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vlad.kozyr.architecture.R
import com.vlad.kozyr.architecture.databinding.ActivityMainBinding
import com.vlad.kozyr.architecture.presentation.model.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<CurrencyViewModel>()

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = CurrencyAdapter()
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            currencies.adapter = adapter
            currencies.layoutManager = LinearLayoutManager(this@MainActivity)
            currencies.addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        viewModel.currencies.observe(this, Observer {
            adapter.submitList(it)
        })

        viewModel.state.observe(this, Observer {
            when (it) {
                is UiState.Loading -> {
                    Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
                }
                is UiState.Completed -> Toast.makeText(this, "Synchronized", Toast.LENGTH_SHORT)
                    .show()
                is UiState.Error -> Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.fetch()

        setContentView(binding.root)
    }
}