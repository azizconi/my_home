package com.example.testapp.feature_app.data.remote.response.door

import com.example.testapp.feature_app.data.local.entity.door.DoorEntity

data class DoorData(
    val favorites: Boolean?,
    val id: Int,
    val name: String?,
    val room: String?,
    val snapshot: String?
) {
    fun mapToEntity() = DoorEntity(
        favorites, id, name, room, snapshot
    )
}