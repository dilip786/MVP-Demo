package com.kotlin.mvpdemo.presenters

import android.content.Context
import android.net.ConnectivityManager
import com.kotlin.mvc_demo.model.PixabayResponseDO
import com.kotlin.mvc_demo.webservices.ApiClient
import com.kotlin.mvc_demo.webservices.ApiInterface
import com.kotlin.mvpdemo.listeners.ImagesPresenterListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageListPresenter(var context: Context, var listener: ImagesPresenterListener) {


    fun getImages(apiKey: String, imageType: String, imagesPerPage: Int, currentPage: Int) {

        if (!isNetworkConnected(context))
            listener.onFailure("Please check your network connection & Try again")
        else {
            // Retrofit setup
            val apiService = ApiClient.client!!.create(ApiInterface::class.java)
            val call = apiService.getImages(
                apiKey, imageType, true, imagesPerPage, currentPage
            )

            call.enqueue(object : Callback<PixabayResponseDO> {
                override fun onResponse(
                    call: Call<PixabayResponseDO>,
                    response: Response<PixabayResponseDO>
                ) {
                    listener.onSuccess(response?.body()?.getImages())
                }

                override fun onFailure(call: Call<PixabayResponseDO>, t: Throwable) {
                    listener.onFailure(t.message)
                }
            })
        }

    }

    private fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
    }
}