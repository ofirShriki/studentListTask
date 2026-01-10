package com.ofirtamar.studentlisttask.models

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val address: String,
    var checkStatus: Boolean,
    val avatarUrlString: String?
)
