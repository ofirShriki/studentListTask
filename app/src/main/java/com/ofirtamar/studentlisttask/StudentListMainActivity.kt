package com.ofirtamar.studentlisttask

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ofirtamar.studentlisttask.databinding.ActivityStudentsRecyclerViewBinding
import com.ofirtamar.studentlisttask.models.Model

class StudentListMainActivity : BaseActivity() {

    private lateinit var binding: ActivityStudentsRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Students List"

        binding = ActivityStudentsRecyclerViewBinding.inflate(layoutInflater)
        super.contentFrame.addView(binding.root)

        binding.studentRecyclerView.setHasFixedSize(true)
        binding.studentRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.studentRecyclerView.adapter = StudentListAdapter(Model.shared.students)
    }
}