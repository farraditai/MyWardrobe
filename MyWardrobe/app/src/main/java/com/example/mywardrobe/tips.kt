package com.example.mywardrobe

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class tips(
    var name: String,
    var description: String,
    var photo: String
) : Parcelable