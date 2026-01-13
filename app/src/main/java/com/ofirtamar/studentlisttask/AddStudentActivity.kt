package com.ofirtamar.studentlisttask

import android.os.Bundle
import com.ofirtamar.studentlisttask.databinding.ActivityAddStudentBinding
import com.ofirtamar.studentlisttask.models.Model
import com.ofirtamar.studentlisttask.models.Student
import com.squareup.picasso.Picasso

class AddStudentActivity : BaseActivity() {

    private lateinit var binding: ActivityAddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "New Student"

        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        super.contentFrame.addView(binding.root)

        // Set the image directly using its resource ID
        binding.addStudentAvatar.setImageResource(R.mipmap.ic_launcher)

        binding.addStudentCancelButton.setOnClickListener {
            finish()
        }

        binding.addStudentSaveButton.setOnClickListener {
            val name = binding.addStudentNameInput.text.toString()
            val id = binding.addStudentIdInput.text.toString()
            val phone = binding.addStudentPhoneInput.text.toString()
            val address = binding.addStudentAddressInput.text.toString()
            val isChecked = binding.addStudentCheckbox.isChecked

            val imageUri = "android.resource://com.ofirtamar.studentlisttask/" + R.mipmap.ic_launcher
            val newStudent = Student(id, name, phone, address, isChecked, imageUri)
            Model.shared.addStudent(newStudent)
            
            setResult(RESULT_OK)
            finish()
        }
    }
}