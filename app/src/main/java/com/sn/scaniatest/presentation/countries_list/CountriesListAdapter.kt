package com.sn.scaniatest.presentation.countries_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sn.scaniatest.databinding.CountryItemBinding
import com.sn.scaniatest.domain.model.Countries


class CountriesListAdapter constructor(private val countryClickListener: ClickListener): ListAdapter<Countries, CountriesListAdapter.ViewHolder>(UtilCallback) {
    class ViewHolder private constructor(private val binding: CountryItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(items: Countries, clickListener: ClickListener){
            binding.country = items
            binding.clickListener = clickListener
        }

        companion object{
            fun attachView(parent: ViewGroup): ViewHolder{
                val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                binding.name.isSelected = true
                binding.population.isSelected = true
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.attachView(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), countryClickListener)
    }
}

class ClickListener(val clickListener: (model: Countries?) -> Unit){
    fun onClick(model: Countries) = clickListener(model)
}

object UtilCallback: DiffUtil.ItemCallback<Countries>() {
    override fun areItemsTheSame(
        oldItem: Countries,
        newItem: Countries
    ): Boolean {
        return oldItem.name === newItem.name
    }

    override fun areContentsTheSame(
        oldItem: Countries,
        newItem: Countries
    ): Boolean {
        return oldItem == newItem
    }

}

