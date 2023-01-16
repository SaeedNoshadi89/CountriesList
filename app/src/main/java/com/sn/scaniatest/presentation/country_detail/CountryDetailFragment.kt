package com.sn.scaniatest.presentation.country_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sn.scaniatest.R
import com.sn.scaniatest.databinding.FragmentCountriesListBinding
import com.sn.scaniatest.databinding.FragmentCountryDetailBinding
import com.sn.scaniatest.presentation.countries_list.ClickListener
import com.sn.scaniatest.presentation.countries_list.CountriesListAdapter
import com.sn.scaniatest.presentation.countries_list.CountriesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailFragment : Fragment() {

    private var _binding: FragmentCountryDetailBinding? = null
    private val viewModel by viewModels<CountryDetailViewModel>()
    private val binding get() = _binding!!
    private val arg by navArgs<CountryDetailFragmentArgs>()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        arg.let {
            viewModel.getCountryDetail(it.name)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            detailViewModel =  viewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}