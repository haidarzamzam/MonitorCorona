package com.haidev.pantaucorona.networks.repositories

import com.haidev.pantaucorona.networks.ServiceFactory
import io.reactivex.disposables.CompositeDisposable

class MainRepository {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = ServiceFactory.create()
}