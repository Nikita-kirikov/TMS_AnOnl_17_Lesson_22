package com.example.tms_lesson_20.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tms_lesson_20.Note
import com.example.tms_lesson_20.NoteAdapter
import com.example.tms_lesson_20.SingletonList
import com.example.tms_lesson_20.databinding.FragmentAllNoteBinding


class AllNoteFragment : Fragment() {

    private var _binding : FragmentAllNoteBinding? = null
    private val binding : FragmentAllNoteBinding
        get() = _binding ?: throw RuntimeException("Fragment is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun init() {
        binding.recycler.adapter = myAdapter
        myAdapter.submitList(ArrayList(SingletonList.getNotes()))
    }

    companion object {
        private val myAdapter = NoteAdapter()

        fun updateList(notes: Note) {
            SingletonList.addItem(notes)
            myAdapter.submitList(ArrayList(SingletonList.getNotes()))
            myAdapter.notifyItemInserted(myAdapter.itemCount)
        }
    }
}