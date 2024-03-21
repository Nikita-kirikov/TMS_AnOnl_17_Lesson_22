package com.example.tms_lesson_20

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_lesson_20.databinding.NoteItemBinding

class NoteViewHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(note: Note, important: Boolean) {
        with(binding) {
            if (important) {
                noteItems.setBackgroundColor(Color.parseColor("#662e1c"))
                header.text = note.header
                text.text = note.text
            } else {
                header.text = note.header
                text.text = note.text
            }
        }
    }

    companion object {
        fun from(parent : ViewGroup) : NoteViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val noteView = NoteItemBinding.inflate(layoutInflater, parent, false)
            return NoteViewHolder(noteView)
        }
    }
}