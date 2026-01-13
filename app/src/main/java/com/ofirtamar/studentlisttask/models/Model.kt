package com.ofirtamar.studentlisttask.models

import com.ofirtamar.studentlisttask.R

class Model private constructor() {

    val students = mutableListOf<Student>()

    init {
        for (i in 1..20) {
            val imageUri = "android.resource://com.ofirtamar.studentlisttask/" + R.mipmap.ic_launcher
            val student = Student(
                id = "ID-${1000 + i}",
                name = "Student $i",
                phone = "054-0100-${i.toString().padStart(2, '0')}",
                address = "${i*10} Kiryat Gat",
                checkStatus = false,
                avatarUrlString = imageUri
            )
            students.add(student)
        }
    }

    companion object {
        val shared = Model()
    }
}
