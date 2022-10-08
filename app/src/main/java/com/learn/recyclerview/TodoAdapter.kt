package com.learn.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learn.recyclerview.databinding.ItemTodoBinding

class TodoAdapter(private var todos: List<Todo>): RecyclerView.Adapter<TodoAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.apply {
            itemText.text = todos[position].title
            itemCheck.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return  todos.size
    }

}