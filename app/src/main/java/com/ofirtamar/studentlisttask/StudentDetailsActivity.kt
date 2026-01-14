package com.ofirtamar.studentlisttask

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.ofirtamar.studentlisttask.databinding.ActivityStudentDetailsBinding
import com.ofirtamar.studentlisttask.models.Model

class StudentDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityStudentDetailsBinding
    private var studentId: String? = null

    companion object {
        private const val EDIT_STUDENT_REQUEST = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Student Details"

        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        super.contentFrame.addView(binding.root)

        studentId = intent.getStringExtra("EXTRA_ID")
        displayStudent()

        binding.editStudentButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("EXTRA_STUDENT_ID", studentId)
            startActivityForResult(intent, EDIT_STUDENT_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_STUDENT_REQUEST && resultCode == Activity.RESULT_OK) {
            val action = data?.getStringExtra("STUDENT_ACTION")
            if (action == "DELETED") {
                finish()
            } else {
                // Check for the new ID and update our internal studentId
                val newStudentId = data?.getStringExtra("EXTRA_NEW_STUDENT_ID")
                if (newStudentId != null) {
                    studentId = newStudentId
                }
                displayStudent()
            }
        }
    }

    private fun displayStudent() {
        studentId?.let { id ->
            val student = Model.shared.getStudentById(id)
            student?.let { student ->
                binding.detailsNameValue.text = student.name
                binding.detailsIdValue.text = student.id
                binding.detailsPhoneValue.text = student.phone
                binding.detailsAddressValue.text = student.address
                binding.detailsCheckbox.isChecked = student.checkStatus
                student.avatarUrlString?.let { uriString ->
                    binding.detailsAvatar.setImageURI(Uri.parse(uriString))
                }
            }
        }
    }
}