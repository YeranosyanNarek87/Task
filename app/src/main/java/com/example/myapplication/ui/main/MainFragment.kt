package com.example.myapplication.ui.main

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.CityData
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.mvi.FirstState
import com.example.myapplication.mvi.MyIntent
import com.example.myapplication.ui.weather.MyFavoriteCityFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentMainBinding
    private val adapter: MyAdapter by lazy { MyAdapter(viewModel.onItemClick) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.itemList.adapter = adapter
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.state
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                when (it) {
                    is FirstState.Loading -> {
                        binding.loading.isVisible = true
                    }
                    is FirstState.LoadedData -> {
                        binding.loading.isVisible = false
                        renderList(it.data)
                    }
                    is FirstState.Error -> {
                        binding.loading.isVisible = false
                        Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.userIntent
            .receiveAsFlow()
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                when (it) {
                    is MyIntent.Clicked -> {
                        if (checkNetwork()) {
                            parentFragmentManager
                                .beginTransaction()
                                .add(R.id.container, MyFavoriteCityFragment.newInstance(it.data))
                                .addToBackStack(null)
                                .commit()
                        } else {
                            Toast.makeText(context, "Please check your network connection", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun checkNetwork(): Boolean {
        val connMgr =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun renderList(cities: List<CityData>) {
        adapter.submitList(cities)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}