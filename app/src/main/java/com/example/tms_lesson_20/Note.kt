package com.example.tms_lesson_20

import java.util.UUID

data class Note(
    val header: String,
    val text: String,
    var important: Boolean = false,
    var id : String = UUID.randomUUID().toString()
)
