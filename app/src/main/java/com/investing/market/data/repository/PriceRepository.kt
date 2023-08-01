package com.investing.market.data.repository

import com.investing.market.data.obj.Coins
import com.investing.market.data.Resource

interface PriceRepository {

    suspend fun fetchStockList(): Resource<List<Coins>>
}