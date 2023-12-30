package com.example.testapp.feature_app.data.remote.response.camera

import com.example.testapp.feature_app.data.local.entity.camera.CameraEntity


data class CameraData(
    val cameras: List<Camera>?,
    val room: List<String>,
)

data class Camera(
    val favorites: Boolean?,
    val id: Int,
    val name: String?,
    val rec: Boolean?,
    val room: String?,
    val snapshot: String?,
) {
    fun mapToEntity() = CameraEntity(
        favorites = favorites,
        id = id,
        name = name,
        rec = rec,
        room = room,
        snapshot = snapshot
    )
}

