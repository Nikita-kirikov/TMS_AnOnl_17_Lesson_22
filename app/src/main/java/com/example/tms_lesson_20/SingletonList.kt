package com.example.tms_lesson_20

object SingletonList {
    private val notes = mutableListOf<Note>()

    fun addItem(item : Note) {
        notes.add(item)
    }

    fun getNotes() : List<Note> {
        return notes
    }

    fun importantItem(item : Note) {
        item.important = !item.important
    }
}