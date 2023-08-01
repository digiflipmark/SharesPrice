package com.investing.market.data

import com.investing.market.data.obj.SharesPriceItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface SharesApi {


    @GET("/any")
    @Headers(
        "X-RapidAPI-Host:latest-stock-price.p.rapidapi.com",
        "X-RapidAPI-Key:2333dd086dmsh9c6293d162fa91ap10a459jsn11c519f9add8"
    )
    suspend fun priceAll(): Response<List<SharesPriceItem>>

}