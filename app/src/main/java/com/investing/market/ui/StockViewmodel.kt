package com.investing.market.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.investing.market.data.obj.Coins
import com.investing.market.data.Resource
import com.investing.market.data.repository.PriceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewmodel @Inject constructor(private val priceRepository: PriceRepository) : ViewModel() {

    val stockList: MutableLiveData<Resource<List<Coins>>> = MutableLiveData()

    private val handlerException = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Caught exception:$throwable")
    }

    fun fetchAllData() {
        stockList.postValue(Resource.Loading())
        CoroutineScope(Dispatchers.Main + handlerException).launch() {

            val list = priceRepository.fetchStockList().data!!
            stockList.postValue(Resource.Success(list))

        }
    }
}