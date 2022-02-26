package com.tegarpenemuan.latihanroomdatabase.room

import androidx.room.Entity

@Entity
data class Note(
    val id: Int,
    val title: String,
    val note: String
)