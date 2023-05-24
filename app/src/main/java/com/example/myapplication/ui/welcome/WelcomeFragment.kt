package com.example.myapplication.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentWelcomeBinding
import com.example.myapplication.mvi.welcome.WelcomeAction
import com.example.myapplication.mvi.welcome.WelcomeIntent
import com.example.myapplication.mvi.welcome.WelcomeState
import com.example.myapplication.ui.main.MainFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment :
    BaseFragment<WelcomeIntent, WelcomeAction, WelcomeState, WelcomeViewModel>() {

    override val viewModel: WelcomeViewModel by viewModel()
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
        Here handel any view click associate the screen: for example start button click
         */
        binding.start.setOnClickListener {

            dispatchIntent(WelcomeIntent.StartLoading)
        }
    }

    override fun render(state: WelcomeState) {
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
                    openNextScreen()

                    /**
                    Here hide loading and open second fragment
                     */
                }
            }
        }
    }

    private fun showHideLoading(visibility: Boolean) {
        binding.loading.isVisible = visibility
    }

    private fun openNextScreen() {
        parentFragmentManager.beginTransaction().add(
            R.id.container, MainFragment.newInstance(null)
        ).addToBackStack(null).commit()
    }

    companion object {
        fun newInstance() = WelcomeFragment()
    }
}