package com.ofirtamar.studentlisttask

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.ofirtamar.studentlisttask.databinding.StudentListRowBinding
import com.ofirtamar.studentlisttask.models.Student

class StudentRowViewHolder(
    private val binding: StudentListRowBinding
): RecyclerView.ViewHolder(binding.root) {

    private var student: Student? = null

    init {
        binding.studentCheckbox.setOnClickListener { view ->
            student?.checkStatus = binding.studentCheckbox.isChecked
        }

        binding.root.setOnClickListener {
            val context = it.context
            val intent = Intent(context, StudentDetailsActivity::class.java).apply {
                putExtra("EXTRA_ID", student?.id)
            }
            context.startActivity(intent)
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
        student.avatarUrlString?.let {
            binding.studentAvatar.setImageURI(Uri.parse(it))
        }
    }
}