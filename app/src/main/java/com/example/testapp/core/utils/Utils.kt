package com.example.testapp.core.utils

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    class Inactive<T> : Resource<T>()
}


fun <T> safeApiCall(call: suspend() -> Response<T>): Flow<Resource<T>> = flow {
    emit(Resource.Loading())

    var remoteData: Response<T>? = null
    try {
        remoteData = call()
        val data = remoteData.body()
        emit(Resource.Success(data))
    } catch (e: HttpException) {
        Log.e("TAG", "safeApiCall: ${e.message}", )
        emit(
            Resource.Error(
                message = Constants.HttpExceptionError,
                data = null
            )
        )
    } catch (e: IOException) {
        Log.e("TAG", "safeApiCall: ${e.message}", )
        emit(
            Resource.Error(
                message = Constants.IOExceptionError,
                data = null
            )
        )
    }
}
