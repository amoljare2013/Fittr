package com.amol.jare.fittrapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FittrDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveData(fittrEntity: FittrEntity)

    @Query("SELECT * FROM fittr_app")
    suspend fun getRecords(): List<FittrEntity>
}