package com.haidev.monitorcorona.features.kasus.viewmodels

import androidx.databinding.ObservableField
import com.haidev.monitorcorona.features.kasus.models.KasusDuniaAttributes
import java.text.DecimalFormat

class ItemKasusDuniaViewModel(
    model: KasusDuniaAttributes
) {
    var total = ""
    var kasusMeninggal = ""
    var kasusSembuh = ""
    var kasusPositif = ""

    var nameCountry: ObservableField<String?> = ObservableField(model.countryRegion)

    init {
        val formatter = DecimalFormat("#,###,###")
        total = formatter.format(model.deaths + model.confirmed + model.recovered)
        kasusMeninggal = formatter.format(model.deaths)
        kasusSembuh = formatter.format(model.recovered)
        kasusPositif = formatter.format(model.confirmed)
    }

    var totalKasus: ObservableField<String?> = ObservableField(total)
    var totalMeninggal: ObservableField<String?> = ObservableField(kasusMeninggal)
    var totalSembuh: ObservableField<String?> = ObservableField(kasusSembuh)
    var totalPositif: ObservableField<String?> = ObservableField(kasusPositif)
}