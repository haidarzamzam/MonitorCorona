package com.haidev.monitorcorona.features.kasus.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.haidev.monitorcorona.features.kasus.models.KasusDuniaModel
import com.haidev.monitorcorona.networks.repositories.MainRepository

class KasusDuniaViewModel(application: Application) : AndroidViewModel(application) {
    var isLoading: ObservableField<Boolean> = ObservableField()
    var kasusDuniaResponse: MutableLiveData<MutableList<KasusDuniaModel>> = MutableLiveData()
    var errorKasusDunia: MutableLiveData<Throwable> = MutableLiveData()

    private var mainRepository = MainRepository()

    fun getDataKasusDunia() {
        isLoading.set(true)
        mainRepository.getDataKasusDunia(
            {
                isLoading.set(false)
                kasusDuniaResponse.postValue(it)
            }, {
                isLoading.set(false)
                errorKasusDunia.postValue(it)
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        mainRepository.cleared()
    }
}