package com.example.modul5.data.source

import com.example.modul5.data.model.Student

class StudentLocalDataSource {
    private val students = listOf(
        Student(2026, "Alya Putri", "Teknik Informatika", 2026),
        Student(2027, "Bima Pratama", "Teknik Informatika", 2026),
        Student(2028, "Citra Lestari", "Teknik Informatika", 2026),
        // 2 data mahasiswa baru
        Student(2029, "Danu Wijaya", "Teknik Informatika", 2026),
        Student(2030, "Eka Putri", "Teknik Informatika", 2026)
    )
    fun getStudentById(id: Int): Student? =
        students.find { it.id == id }
    fun getStudents(): List<Student> =
        students
}