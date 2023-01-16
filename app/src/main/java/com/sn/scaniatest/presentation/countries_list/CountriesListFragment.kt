package com.sn.scaniatest.presentation.countries_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sn.scaniatest.R
import com.sn.scaniatest.databinding.FragmentCountriesListBinding
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import javax.inject.Inject

@AndroidEntryPoint
class CountriesListFragment : Fragment() {

    private var _binding: FragmentCountriesListBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<CountriesListViewModel>()
    lateinit var adapter: CountriesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            countriesViewModel = viewModel
            adapter = CountriesListAdapter(ClickListener {
                it?.name?.common?.let {
                    findNavController().navigate(
                        CountriesListFragmentDirections.actionCountriesListFragmentToCountryDetailFragment()
                            .setName(it)
                    )
                }
            })
            recyclerview.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}