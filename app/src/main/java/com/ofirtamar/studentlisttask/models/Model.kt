package com.ofirtamar.studentlisttask.models

import com.ofirtamar.studentlisttask.R

class Model private constructor() {

    val students = mutableListOf<Student>()

    private fun updateStudentInPlace(id: String, student: Student) {
        val index = students.indexOfFirst { it.id == id }
        if (index != -1) {
            students[index] = student
        }
    }

    fun addStudent(student: Student) {
        val index = students.indexOfFirst { it.id == student.id }
        if (index != -1) {
            updateStudentInPlace(student.id, student)
        } else {
            students.add(student)
        }
    }

    fun editStudent(originalId: String, updatedStudent: Student) {
        if (originalId == updatedStudent.id) {
            updateStudentInPlace(originalId, updatedStudent)
        } else {
            deleteStudent(originalId)
            addStudent(updatedStudent)
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