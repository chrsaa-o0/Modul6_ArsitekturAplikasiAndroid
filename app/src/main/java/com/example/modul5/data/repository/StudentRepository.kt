package com.example.modul5.data.repository

import com.example.modul5.data.model.Student
import com.example.modul5.data.source.StudentLocalDataSource

interface StudentRepository {
    fun getStudentById(id: Int): Student?
    fun getStudents(): List<Student>
}

class DefaultStudentRepository(
    private val dataSource: StudentLocalDataSource
) : StudentRepository {
    override fun getStudentById(id: Int): Student? =
        dataSource.getStudentById(id)

    override fun getStudents(): List<Student> =
        dataSource.getStudents()
}