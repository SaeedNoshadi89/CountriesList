package com.sn.scaniatest.utils

import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.facebook.shimmer.ShimmerFrameLayout
import com.sn.scaniatest.R
import com.sn.scaniatest.data.util.Status
import com.sn.scaniatest.domain.model.Countries
import com.sn.scaniatest.presentation.countries_list.CountriesListAdapter

@BindingAdapter("listOfCountries")
fun RecyclerView.bindListOfCountriesRecyclerViewAdapter(
    data: List<Countries>?
) {
    data?.let {
        val adapter = adapter as CountriesListAdapter
        adapter.submitList(it)
    }
}

@BindingAdapter("setShimmerLoadingStatus")
fun ShimmerFrameLayout.setShimmerLoadingStatus(status: Status?) {
    isVisible = when (status) {
        Status.LOADING -> true
        Status.ERROR -> true
        else -> false
    }
}

@BindingAdapter("setRecyclerStatus")
fun RecyclerView.setRecyclerStatus(status: Status?) {
    isVisible = when (status) {
        Status.LOADING -> false
        Status.ERROR -> false
        else -> true
    }
}

@BindingAdapter("setDetailStatus")
fun CardView.setDetailStatus(status: Status?) {
    isVisible = when (status) {
        Status.LOADING -> false
        Status.ERROR -> false
        else -> true
    }
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    url?.let {
        val imgUrl = it.toUri()
        imageView.load(imgUrl){
            crossfade(true)
            placeholder(R.drawable.loading)
            transformations(RoundedCornersTransformation())
        }
    }
}



