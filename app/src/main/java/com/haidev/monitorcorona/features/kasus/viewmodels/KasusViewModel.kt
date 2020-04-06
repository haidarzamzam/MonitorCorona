package com.haidev.monitorcorona.features.kasus.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.haidev.monitorcorona.features.kasus.models.KasusModel
import com.haidev.monitorcorona.networks.repositories.MainRepository

class KasusViewModel(application: Application) : AndroidViewModel(application) {
    var isLoading: ObservableField<Boolean> = ObservableField()
    var kasusResponse: MutableLiveData<MutableList<KasusModel>> = MutableLiveData()
    var errorKasus: MutableLiveData<Throwable> = MutableLiveData()

    private var mainRepository = MainRepository()

    fun getDataKasus() {
        isLoading.set(true)
        mainRepository.getDataKasus(
            {
                isLoading.set(false)
                kasusResponse.postValue(it)
            }, {
                isLoading.set(false)
                errorKasus.postValue(it)
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        mainRepository.cleared()
    }
}