package com.investing.market.app

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.internal.Contexts.getApplication


@HiltAndroidApp
class SharesPriceApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this) {}


    }
}