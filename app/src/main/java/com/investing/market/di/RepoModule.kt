package com.investing.market.di

import com.investing.market.data.SharesApi
import com.investing.market.data.repository.PriceImp
import com.investing.market.data.repository.PriceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideStockList(sharesApi: SharesApi):PriceRepository{

        return PriceImp(sharesApi)
    }

}