package com.ofirtamar.studentlisttask

import android.os.Bundle
import com.ofirtamar.studentlisttask.databinding.ActivityStudentDetailsBinding
import com.squareup.picasso.Picasso

class StudentDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityStudentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Student Details"

        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        super.contentFrame.addView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAME")
        val id = intent.getStringExtra("EXTRA_ID")
        val phone = intent.getStringExtra("EXTRA_PHONE")
        val address = intent.getStringExtra("EXTRA_ADDRESS")
        val checked = intent.getBooleanExtra("EXTRA_CHECKED", false)
        val avatarUri = intent.getStringExtra("EXTRA_AVATAR_URI")

        binding.detailsNameValue.text = name
        binding.detailsIdValue.text = id
        binding.detailsPhoneValue.text = phone
        binding.detailsAddressValue.text = address
        binding.detailsCheckbox.isChecked = checked

        Picasso.get()
            .load(avatarUri)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(binding.detailsAvatar)
    }
}