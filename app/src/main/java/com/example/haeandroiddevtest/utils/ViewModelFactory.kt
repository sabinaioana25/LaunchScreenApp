package com.example.haeandroiddevtest.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.haeandroiddevtest.fragments.apps.AppListViewModel
import com.example.haeandroiddevtest.fragments.cities.CityViewModel
import com.example.haeandroiddevtest.repository.HAERepository

class ViewModelFactory(private val app: Application, private val repository: HAERepository?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
            return repository?.let { CityViewModel(app, it) } as T
        } else if (modelClass.isAssignableFrom(AppListViewModel::class.java)) {
            return AppListViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}