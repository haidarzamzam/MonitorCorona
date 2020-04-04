package com.haidev.pantaucorona.networks

import com.haidev.pantaucorona.features.kasus.models.KasusDuniaModel
import com.haidev.pantaucorona.features.kasus.models.KasusModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {
    @GET("indonesia/provinsi")
    fun getDataKasus(): Observable<MutableList<KasusModel>>

    @GET("dunia")
    fun getDataKasusDunia(): Observable<MutableList<KasusDuniaModel>>
}