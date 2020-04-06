package com.haidev.monitorcorona.preferences

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AppModel(
    var location: String? = null
) : Parcelable