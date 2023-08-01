package com.investing.market.data


sealed class Resource<T>(
    val status: HttpStatus,
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : Resource<T>(HttpStatus.SUCCESS, data)
    class Loading<T> : Resource<T>(HttpStatus.LOADING)
    class Error<T>(message: String) : Resource<T>(HttpStatus.ERROR, message = message)
    class NetworkError<T> : Resource<T>(HttpStatus.NETWORK_ERROR)

}