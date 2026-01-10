package com.ofirtamar.studentlisttask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ofirtamar.studentlisttask.databinding.StudentListRowBinding
import com.ofirtamar.studentlisttask.models.Student

class StudentListAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentRowViewHolder>() {
    override fun getItemCount() = students.size

    override fun onBindViewHolder(holder: StudentRowViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentRowViewHolder {
        val binding = StudentListRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StudentRowViewHolder(binding)
    }
}
