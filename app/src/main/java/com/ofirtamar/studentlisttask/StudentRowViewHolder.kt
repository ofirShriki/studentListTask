package com.ofirtamar.studentlisttask

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.ofirtamar.studentlisttask.databinding.StudentListRowBinding
import com.ofirtamar.studentlisttask.models.Student
import com.squareup.picasso.Picasso

class StudentRowViewHolder(
    private val binding: StudentListRowBinding
): RecyclerView.ViewHolder(binding.root) {

    private var student: Student? = null

    init {
        binding.studentCheckbox.setOnClickListener { view ->
            student?.checkStatus = binding.studentCheckbox.isChecked
        }
    }

    fun bind(student: Student, position: Int) {
        this.student = student
        binding.studentNameTextView.text = student.name
        binding.studentIdTextView.text = student.id
        binding.studentCheckbox.apply {
            isChecked = student.checkStatus
            tag = position
        }
        Log.v("TAG", "Loading image from URI: ${student.avatarUrlString}")
        Picasso
            .get()
            .load(student.avatarUrlString)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(binding.studentAvatar)
    }
}