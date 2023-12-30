package com.example.testapp.feature_app.data.repository

import com.example.testapp.core.utils.Resource
import com.example.testapp.core.utils.safeApiCall
import com.example.testapp.feature_app.data.remote.HomeApi
import com.example.testapp.feature_app.data.remote.response.StandardResponseModel
import com.example.testapp.feature_app.data.remote.response.camera.CameraData
import com.example.testapp.feature_app.data.remote.response.door.DoorData
import com.example.testapp.feature_app.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(private val api: HomeApi): HomeRepository {
    override fun getCamera(): Flow<Resource<StandardResponseModel<CameraData>>> = safeApiCall {
        api.getCameras()
    }

    override fun getDoor(): Flow<Resource<StandardResponseModel<List<DoorData>>>> = safeApiCall {
        api.getDoors()
    }
}