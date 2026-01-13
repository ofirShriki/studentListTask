package com.ofirtamar.studentlisttask.models

import com.ofirtamar.studentlisttask.R

class Model private constructor() {

    val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    companion object {
        val shared = Model()
    }
}
