package com.haidev.pantaucorona.networks.repositories

import com.haidev.pantaucorona.features.kasus.models.KasusDuniaModel
import com.haidev.pantaucorona.features.kasus.models.KasusModel
import com.haidev.pantaucorona.networks.ApiObserver
import com.haidev.pantaucorona.networks.ServiceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {
    private val compositeDisposable = CompositeDisposable()
    private val apiService = ServiceFactory.create()

    fun getDataKasus(
        onResult: (MutableList<KasusModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.getDataKasus()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<MutableList<KasusModel>>(compositeDisposable) {
                override fun onApiSuccess(data: MutableList<KasusModel>) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun getDataKasusDunia(
        onResult: (MutableList<KasusDuniaModel>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.getDataKasusDunia()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<MutableList<KasusDuniaModel>>(compositeDisposable) {
                override fun onApiSuccess(data: MutableList<KasusDuniaModel>) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun cleared() {
        compositeDisposable.clear()
    }
}