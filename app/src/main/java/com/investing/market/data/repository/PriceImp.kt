package com.investing.market.data.repository

import com.investing.market.data.obj.Coins
import com.investing.market.data.Resource
import com.investing.market.data.SharesApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class PriceImp(private val sharesApi: SharesApi) : PriceRepository {

    override suspend fun fetchStockList(): Resource<List<Coins>> {

        return withContext(Dispatchers.IO) {

            try {

                val response = sharesApi.priceAll()
                if (response.isSuccessful && response.body() != null) {
                    val coin = response.body()!!.map { it.toCoins() }
                    delay(5000)
                    Resource.Success(coin)
                } else {
                    Resource.Error(response.errorBody().toString())
                }
            } catch (e: HttpException) {
                Resource.Error(e.message.toString())
            } catch (e: NullPointerException) {
                Resource.Error(e.message.toString())
            } catch (e: CancellationException) {
                Resource.Error(e.message.toString())
            } catch (e: Exception) {
                Resource.Error(e.message.toString())
            }
        }
    }
}