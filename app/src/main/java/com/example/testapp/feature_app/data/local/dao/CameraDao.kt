package com.example.testapp.feature_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.testapp.feature_app.data.local.entity.camera.CameraEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CameraDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(model: CameraEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(model: List<CameraEntity>)



    @Update
    suspend fun update(model: CameraEntity)

    @Delete
    suspend fun delete(model: CameraEntity)


    @Query("select * from camera where `id` = :id")
    fun get(id: String): Flow<CameraEntity?>


    @Query("select * from camera")
    fun getAll(): Flow<List<CameraEntity>>

}