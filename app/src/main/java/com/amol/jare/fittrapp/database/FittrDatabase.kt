package com.amol.jare.fittrapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FittrEntity::class], version = 1, exportSchema = false)
abstract class FittrDatabase : RoomDatabase() {
    abstract fun fittrdao(): FittrDao

    companion object {
        @Volatile
        private var INSTANCE: FittrDatabase? = null

        fun getDatabase(context: Context): FittrDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FittrDatabase::class.java,
                    "fittr_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}