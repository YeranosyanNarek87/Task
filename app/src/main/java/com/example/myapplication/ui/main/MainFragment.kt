package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.domain.ItemData
import com.example.myapplication.mvi.main.MainAction
import com.example.myapplication.mvi.main.MainIntent
import com.example.myapplication.mvi.main.MainState
import com.example.myapplication.ui.util.MyAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainFragment :
    BaseFragment<MainIntent, MainAction, MainState, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentMainBinding
    private val adapter: MyAdapter by lazy { MyAdapter(onItemClick)}

    private val onItemClick: (ItemData) -> Unit = {
        dispatchIntent(MainIntent.HandleClick(it))
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
        /**
        Set adapter
         */
        binding.itemList.adapter = adapter
        /**
        Here handel any view click associate the screen: for example start button click
         */
        binding.start.setOnClickListener {
            dispatchIntent(MainIntent.StartLoading)
        }
    }

    override fun render(state: MainState) {
        with(state) {
            when {
                start -> {
                    /**
                    Here draw your logic in the screen
                     */
                }
                showLoading -> {
                    /**
                    Here show the loading animation when data will be loaded
                     */
                }
                hideLoading -> {
                    /**
                    Here hide loading and open second fragment
                     */
                }
            }
        }
    }

    private fun renderList(data: List<ItemData>) {
        /**
        Set items for adapter
         */
        adapter.submitList(data)
    }

    private fun showHideLoading(visibility: Boolean) {
        /**
        Show loading
         */
    }

    private fun openNextScreen() {
        /**
        Open next fragment if needed
         */
    }

    companion object {
        fun newInstance(data: Any?) = MainFragment().apply {
            arguments = bundleOf("data" to data)
        }
    }
}