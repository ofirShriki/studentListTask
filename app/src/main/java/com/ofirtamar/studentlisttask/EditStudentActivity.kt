package com.ofirtamar.studentlisttask

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.ofirtamar.studentlisttask.databinding.ActivityEditStudentBinding
import com.ofirtamar.studentlisttask.models.Model
import com.ofirtamar.studentlisttask.models.Student

class EditStudentActivity : BaseActivity() {

    private lateinit var binding: ActivityEditStudentBinding
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Edit Student"

        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        super.contentFrame.addView(binding.root)

        val studentId = intent.getStringExtra("EXTRA_STUDENT_ID")
        student = Model.shared.getStudentById(studentId!!)

        student?.let { student ->
            binding.editStudentNameInput.setText(student.name)
            binding.editStudentIdInput.setText(student.id)
            binding.editStudentPhoneInput.setText(student.phone)
            binding.editStudentAddressInput.setText(student.address)
            binding.editStudentCheckbox.isChecked = student.checkStatus

            student.avatarUrlString?.let { uriString ->
                binding.editStudentAvatar.setImageURI(Uri.parse(uriString))
            }
        }

        binding.editStudentCancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        binding.editStudentDeleteButton.setOnClickListener {
            student?.let { student ->
                Model.shared.deleteStudent(student.id)
                val resultIntent = Intent()
                resultIntent.putExtra("STUDENT_ACTION", "DELETED")
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }

        binding.editStudentSaveButton.setOnClickListener {
            student?.let { originalStudent ->
                val newId = binding.editStudentIdInput.text.toString()

                val updatedStudent = originalStudent.copy(
                    id = newId,
                    name = binding.editStudentNameInput.text.toString(),
                    phone = binding.editStudentPhoneInput.text.toString(),
                    address = binding.editStudentAddressInput.text.toString(),
                    checkStatus = binding.editStudentCheckbox.isChecked
                )
                
                Model.shared.editStudent(originalStudent.id, updatedStudent)

                val resultIntent = Intent()
                resultIntent.putExtra("STUDENT_ACTION", "EDITED")
                resultIntent.putExtra("EXTRA_NEW_STUDENT_ID", updatedStudent.id)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}