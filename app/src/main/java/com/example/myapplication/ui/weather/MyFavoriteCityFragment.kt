package com.example.myapplication.ui.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.myapplication.data.CityData
import com.example.myapplication.data.CityWeatherData
import com.example.myapplication.databinding.FragmentMyFavoriteCityBinding
import com.example.myapplication.mvi.SecondState
import com.example.myapplication.repo.LocalDataProviderImpl.Companion.YEREVAN
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFavoriteCityFragment : Fragment() {

    private val viewModel: MyFavoriteCityViewModel by viewModel()
    private lateinit var binding: FragmentMyFavoriteCityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchData(
            arguments?.getParcelable("data", CityData::class.java) ?: CityData(
                "yerevan",
                name = "Yerevan",
                avatar = YEREVAN
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyFavoriteCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.state
            .flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                when (it) {
                    is SecondState.Loading -> {
                        binding.loading.isVisible = true
                    }
                    is SecondState.LoadedData -> {
                        binding.loading.isVisible = false
                        renderUi(it.data)
                    }
                    is SecondState.Error -> {
                        binding.loading.isVisible = false
                        Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
                        parentFragmentManager.popBackStack()
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun renderUi(city: CityWeatherData) {
        binding.run {
            Glide.with(root.context)
                .load(city.avatar)
                .into(image)

            country.text = city.country
            val textRegion = "City ${city.name} Region ${city.region}"
            val textTempC = "Temperature celsius ${city.tempC}"
            val textTempF = "Temperature fahrenheit ${city.tempF}"
            capital.text = textRegion
            tempC.text = textTempC
            tempF.text = textTempF
        }
    }

    companion object {
        fun newInstance(cityData: CityData) = MyFavoriteCityFragment().apply {
            arguments = bundleOf("data" to cityData)
        }
    }
}