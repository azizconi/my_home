package com.example.testapp.feature_app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.testapp.feature_app.data.local.entity.door.DoorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DoorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(model: DoorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(model: List<DoorEntity>)


    @Update
    suspend fun update(model: DoorEntity)

    @Delete
    suspend fun delete(model: DoorEntity)


    @Query("select * from door where `id` = :id")
    fun get(id: String): Flow<DoorEntity?>


    @Query("select * from door")
    fun getAll(): Flow<List<DoorEntity>>

}