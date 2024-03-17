package com.example.tms_lesson_20

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalStateException

class NoteAdapter :
    ListAdapter<Note, RecyclerView.ViewHolder>(Companion) {

    var onLongClick : ((Note) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return when(val item = getItem(position)) {
            is Note -> {
                if (item.important) {
                    IMPORTANT_TYPE
                } else {
                    UNIMPORTANT_TYPE
                }
            }
            else -> throw IllegalStateException()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            UNIMPORTANT_TYPE -> NoteViewHolder.from(parent)
            IMPORTANT_TYPE -> NoteViewHolder.from(parent)
            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item is Note && holder is NoteViewHolder) {
            holder.bind(item, item.important, onLongClick)
        } else {
            throw IllegalStateException()
        }
    }

    companion object : DiffUtil.ItemCallback<Note>() {
        private const val IMPORTANT_TYPE = 1
        private const val UNIMPORTANT_TYPE = 2

        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id  == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
}