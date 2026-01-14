package com.ofirtamar.studentlisttask.models

import com.ofirtamar.studentlisttask.R

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String,
    var checkStatus: Boolean,
    val avatarUrlString: String? = "android.resource://com.ofirtamar.studentlisttask/" + R.mipmap.ic_launcher
)
