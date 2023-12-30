package com.example.testapp.feature_app.data.remote.response

data class StandardResponseModel<T>(
    val `data`: T,
    val success: Boolean
)