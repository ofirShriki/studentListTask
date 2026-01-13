package com.ofirtamar.studentlisttask.models

import com.ofirtamar.studentlisttask.R

class Model private constructor() {

    val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(student: Student) {
        val index = students.indexOfFirst { it.id == student.id }
        if (index != -1) {
            students[index] = student
        }
    }

    fun deleteStudent(studentId: String) {
        students.removeAll { it.id == studentId }
    }

    fun getStudentById(studentId: String): Student? {
        return students.find { it.id == studentId }
    }

    companion object {
        val shared = Model()
    }
}
