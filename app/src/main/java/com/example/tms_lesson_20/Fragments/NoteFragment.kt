package com.example.tms_lesson_20.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.tms_lesson_20.Note
import com.example.tms_lesson_20.databinding.FragmentNoteBinding


class NoteFragment : Fragment() {

    private var _binding : FragmentNoteBinding? = null
    private val binding : FragmentNoteBinding
        get() = _binding ?: throw RuntimeException("Fragment is null")
    private lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button = binding.save
        super.onViewCreated(view, savedInstanceState)
        actions()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun actions() {
        button.setOnClickListener {
            createNewNote()
            Toast.makeText(context, "Note has been added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun createNewNote() {
        with(binding) {
            val headerNote = header.text.toString().trim()
            val textNote = text.text.toString().trim()
            val important = radioButton.isChecked

            val newNote = Note(headerNote, textNote, important)

            AllNoteFragment.updateList(newNote)

            header.text?.clear()
            text.text?.clear()
            radioButton.isChecked = false
        }
    }
}