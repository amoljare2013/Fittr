package com.amol.jare.fittrapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fittr_app")
data class FittrEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "imageHref")
    var imageHref: String,

    @ColumnInfo(name = "title")
    var title: String
)