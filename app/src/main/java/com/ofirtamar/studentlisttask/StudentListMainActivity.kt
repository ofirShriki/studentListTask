package com.ofirtamar.studentlisttask

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ofirtamar.studentlisttask.databinding.ActivityStudentsRecyclerViewBinding
import com.ofirtamar.studentlisttask.models.Student

class StudentListMainActivity : BaseActivity() {

    private lateinit var binding: ActivityStudentsRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Students List"

        // Inflate the content layout using View Binding
        binding = ActivityStudentsRecyclerViewBinding.inflate(layoutInflater)

        // Add the content view to the base activity's content frame
        super.contentFrame.addView(binding.root)

        // Now you can safely access the RecyclerView via the binding object
        binding.studentRecyclerView.layoutManager = LinearLayoutManager(this)

        val students = mutableListOf<Student>()

        // Create a URI string that points to a local drawable resource
        val imageUri = "android.resource://com.ofirtamar.studentlisttask/" + R.mipmap.ic_launcher

        students.add(Student("1", "John Doe", "555-1234", "123 Main St", false, imageUri))
        students.add(Student("2", "Jane Smith", "555-5678", "456 Oak Ave", true, imageUri))
        students.add(Student("3", "Peter Jones", "555-9012", "789 Pine Ln", false, imageUri))

        val adapter = StudentListAdapter(students)
        binding.studentRecyclerView.adapter = adapter
    }
}