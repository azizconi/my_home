package com.example.testapp.feature_app.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.core.utils.Resource
import com.example.testapp.feature_app.data.local.dao.CameraDao
import com.example.testapp.feature_app.data.local.dao.DoorDao
import com.example.testapp.feature_app.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val cameraDao: CameraDao,
    private val doorDao: DoorDao,
) : ViewModel() {


    val cameras = cameraDao.getAll()
    val doors = doorDao.getAll()


    init {
        getCamera()
        getDoor()
    }

    private fun getCamera() {
        viewModelScope.launch {
            repository.getCamera().onEach { result ->
                Log.e("TAG", "getCamera: result = $result", )
                when(result) {
                    is Resource.Success -> {
                        result.data?.data?.let {
                            val list = it.cameras?.map { it.mapToEntity() }
                            Log.e("TAG", "getCamera: ${it.cameras}", )
                            cameraDao.addAll(list ?: emptyList())
                        }
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Inactive -> {

                    }
                    is Resource.Loading -> {

                    }
                }
            }.launchIn(this)
        }
    }


    private fun getDoor() {
        viewModelScope.launch {
            repository.getDoor().onEach { result ->
                Log.e("TAG", "getCamera: result = $result", )
                when(result) {
                    is Resource.Success -> {
                        result.data?.data?.let {

                            val list = it.map { it.mapToEntity() }
                            doorDao.addAll(list)
                        }
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Inactive -> {

                    }
                    is Resource.Loading -> {

                    }
                }
            }.launchIn(this)
        }
    }

}