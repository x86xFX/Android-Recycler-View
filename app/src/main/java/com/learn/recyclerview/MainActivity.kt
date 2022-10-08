package com.learn.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toDoList = mutableListOf(
            Todo("Learn Kotlin", true),
            Todo("Learn Android Development", true),
            Todo("Learn Concepts and Patterns", false),
            Todo("Apply job", false)
        )

        val adapter = TodoAdapter(toDoList)
        binding.recycleView.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.addBtn.setOnClickListener {
            val title = binding.editText.text.toString()
            val todo = Todo(title, false)
            toDoList.add(todo)
            //adapter.notifyDataSetChanged() don't use. Because it will update all entries
            adapter.notifyItemInserted(toDoList.size - 1)
        }
    }


}