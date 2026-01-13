package com.ofirtamar.studentlisttask

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ofirtamar.studentlisttask.databinding.ActivityStudentsRecyclerViewBinding
import com.ofirtamar.studentlisttask.models.Model

class StudentListMainActivity : BaseActivity() {

    private lateinit var binding: ActivityStudentsRecyclerViewBinding

    companion object {
        private const val ADD_STUDENT_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Students List"

        binding = ActivityStudentsRecyclerViewBinding.inflate(layoutInflater)
        super.contentFrame.addView(binding.root)

        binding.studentRecyclerView.setHasFixedSize(true)
        binding.studentRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.studentRecyclerView.adapter = StudentListAdapter(Model.shared.students)

        binding.addStudentButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivityForResult(intent, ADD_STUDENT_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_STUDENT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            binding.studentRecyclerView.adapter?.notifyDataSetChanged()
        }
    }
}