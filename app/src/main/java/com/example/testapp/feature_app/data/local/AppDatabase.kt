package com.example.testapp.feature_app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testapp.feature_app.data.local.dao.CameraDao
import com.example.testapp.feature_app.data.local.dao.DoorDao
import com.example.testapp.feature_app.data.local.entity.camera.CameraEntity
import com.example.testapp.feature_app.data.local.entity.door.DoorEntity


@Database(
    entities = [
        DoorEntity::class,
        CameraEntity::class
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun doorDao(): DoorDao
    abstract fun cameraDao(): CameraDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "home_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }

        }
    }

}