package com.kotlin.mvc_demo.model

import com.google.gson.annotations.SerializedName

class PixabayResponseDO {
    @SerializedName("totalHits")
    private val totalHits: Int? = 0


    @SerializedName("hits")
    private val images: ArrayList<ImageDO>? = null

    fun getTotalHits(): Int? {
        return totalHits;
    }

    fun getImages(): ArrayList<ImageDO>? {
        return images;
    }

}