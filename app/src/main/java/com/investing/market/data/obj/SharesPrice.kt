package com.investing.market.data.obj

data class SharesPrice(
    val sharesPrice: List<SharesPriceItem>
)

data class SharesPriceItem(
    val yearLow: Any,
    val symbol: String,
    val identifier: String,
    val totalTradedVolume: Long,
    val change: Any,
    val dayLow: Any,
    val perChange30d: Any,
    val yearHigh: Any,
    val perChange365d: Any,
    val previousClose: Any,
    val pChange: Any,
    val totalTradedValue: Any,
    val open: Any,
    val dayHigh: Any,
    val lastPrice: Any,
    val lastUpdateTime: String
) {
    fun toCoins(): Coins {
        return Coins(
            yearLow = yearLow,
            symbol = symbol,
            identifier = identifier,
            totalTradedVolume = totalTradedVolume,
            change = change,
            dayLow = dayLow,
            perChange30d = perChange30d,
            yearHigh = yearHigh,
            perChange365d = perChange365d,
            previousClose = previousClose,
            pChange = pChange,
            totalTradedValue = totalTradedValue,
            open = open,
            dayHigh = dayHigh,
            lastPrice = lastPrice,
            lastUpdateTime = lastUpdateTime
        )
    }
}

