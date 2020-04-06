package com.haidev.monitorcorona.networks

import com.haidev.monitorcorona.features.kasus.models.KasusDuniaModel
import com.haidev.monitorcorona.features.kasus.models.KasusModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {
    @GET("indonesia/provinsi")
    fun getDataKasus(): Observable<MutableList<KasusModel>>

    @GET("dunia")
    fun getDataKasusDunia(): Observable<MutableList<KasusDuniaModel>>
}