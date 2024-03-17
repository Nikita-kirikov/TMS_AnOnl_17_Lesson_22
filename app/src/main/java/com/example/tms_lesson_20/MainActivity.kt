package com.example.tms_lesson_20
/*
переписать проект на fragments
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tms_lesson_20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}