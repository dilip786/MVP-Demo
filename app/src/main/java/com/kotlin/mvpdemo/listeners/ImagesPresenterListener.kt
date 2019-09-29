package com.kotlin.mvpdemo.listeners

import com.kotlin.mvc_demo.model.ImageDO

interface ImagesPresenterListener
{
    fun onSuccess(images: ArrayList<ImageDO>?)
    fun onFailure(errorMessage: String?)
}