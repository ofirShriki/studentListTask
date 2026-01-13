package com.ofirtamar.studentlisttask

import android.content.Intent
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

        binding.root.setOnClickListener {
            val context = it.context
            val intent = Intent(context, StudentDetailsActivity::class.java).apply {
                putExtra("EXTRA_NAME", student?.name)
                putExtra("EXTRA_ID", student?.id)
                putExtra("EXTRA_PHONE", student?.phone)
                putExtra("EXTRA_ADDRESS", student?.address)
                putExtra("EXTRA_CHECKED", student?.checkStatus)
                putExtra("EXTRA_AVATAR_URI", student?.avatarUrlString)
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
        Log.v("TAG", "Loading image from URI: ${student.avatarUrlString}")
        Picasso
            .get()
            .load(student.avatarUrlString)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(binding.studentAvatar)
    }
}