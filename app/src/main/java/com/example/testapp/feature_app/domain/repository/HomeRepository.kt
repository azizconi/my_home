package com.example.testapp.feature_app.domain.repository

import com.example.testapp.core.utils.Resource
import com.example.testapp.feature_app.data.remote.response.StandardResponseModel
import com.example.testapp.feature_app.data.remote.response.camera.CameraData
import com.example.testapp.feature_app.data.remote.response.door.DoorData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getCamera(): Flow<Resource<StandardResponseModel<CameraData>>>
    fun getDoor(): Flow<Resource<StandardResponseModel<List<DoorData>>>>
}