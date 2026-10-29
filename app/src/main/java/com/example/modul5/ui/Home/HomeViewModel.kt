package com.example.modul5.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modul5.data.model.Student
import com.example.modul5.data.repository.StudentRepository
data class HomeUiState(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false
)
class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set
    init {
        loadStudents()
    }
    fun loadStudents() {
        uiState = uiState.copy(isLoading = true)
        val studentList = repository.getStudents()
        uiState = uiState.copy(
            students = studentList,
            isLoading = false
        )
    }
    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(repository) as T
                }
            }
    }
}