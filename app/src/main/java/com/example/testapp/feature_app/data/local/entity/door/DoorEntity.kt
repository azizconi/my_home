package com.example.testapp.feature_app.data.local.entity.door

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("door")
data class DoorEntity(
    val favorites: Boolean?,
    @PrimaryKey
    val id: Int,
    val name: String?,
    val room: String?,
    val snapshot: String?
)
