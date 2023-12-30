package com.example.testapp.feature_app.data.remote

import com.example.testapp.feature_app.data.remote.response.StandardResponseModel
import com.example.testapp.feature_app.data.remote.response.camera.CameraData
import com.example.testapp.feature_app.data.remote.response.door.DoorData
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {

    @GET("rubetek/cameras")
    suspend fun getCameras(): Response<StandardResponseModel<CameraData>>

    @GET("rubetek/doors")
    suspend fun getDoors(): Response<StandardResponseModel<List<DoorData>>>

}