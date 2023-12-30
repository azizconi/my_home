package com.example.testapp.feature_app.data.local.entity.camera

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("camera")
data class CameraEntity(
    val favorites: Boolean?,
    @PrimaryKey
    val id: Int,
    val name: String?,
    val rec: Boolean?,
    val room: String?,
    val snapshot: String?
)
