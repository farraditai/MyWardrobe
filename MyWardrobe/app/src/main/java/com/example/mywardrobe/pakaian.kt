package com.example.mywardrobe

import android.media.Image
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.File

@Parcelize
data class pakaian(
    var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var jenis: String? = null,
    var merek: String? = null,
    var foto: File? = null
) : Parcelable