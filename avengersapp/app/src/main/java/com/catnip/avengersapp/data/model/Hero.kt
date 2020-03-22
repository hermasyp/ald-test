package com.catnip.avengersapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

@Parcelize
data class Hero(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("images")
    val images: List<String>
) : Parcelable

data class Heroes(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("data")
    val heroes: List<Hero>
)
