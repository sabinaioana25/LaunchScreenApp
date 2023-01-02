package com.example.haeandroiddevtest.utils

import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.haeandroiddevtest.fragments.apps.AppListItemAdapter
import com.example.haeandroiddevtest.fragments.cities.CityItemAdapter
import com.example.haeandroiddevtest.domain.AppItem
import com.example.haeandroiddevtest.domain.City
import java.util.*

@BindingAdapter("bindCityData")
fun RecyclerView.bindCityData(cities: MutableList<City>?) = cities?.let {
    (adapter as CityItemAdapter).submitList(cities)
}

@BindingAdapter("bindCityLayout")
fun LinearLayout.bindCityLayout(city: City) {
    (getChildAt(0) as TextView).text = city.city
    (getChildAt(1) as TextView).text = city.country
    (getChildAt(2) as TextView).text = city.temperature.toString()
    (getChildAt(3) as TextView).text = city.description
}

@BindingAdapter("bindAppData")
fun RecyclerView.bindAppData(appItems: MutableList<AppItem>?) = appItems.let {
    (adapter as AppListItemAdapter).submitList(appItems)
}

@BindingAdapter("bindSingleAppInfo")
fun LinearLayout.bindSingleAppInfo(appItem: AppItem) {
    (getChildAt(0) as TextView).text = appItem.appName
    (getChildAt(0) as TextView).text = appItem.packageName
}