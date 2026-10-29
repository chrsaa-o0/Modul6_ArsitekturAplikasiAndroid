package com.example.modul5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.modul5.data.repository.DefaultStudentRepository
import com.example.modul5.data.source.StudentLocalDataSource
import com.example.modul5.screen.AboutScreen
import com.example.modul5.screen.DetailScreen
import com.example.modul5.screen.HomeScreen
import com.example.modul5.screen.ProfileScreen
import com.example.modul5.ui.detail.DetailViewModel
import com.example.modul5.ui.home.HomeViewModel

@Composable
fun NavigationLabApp() {
    val navController = rememberNavController()
    val dataSource = remember { StudentLocalDataSource() }
    val repository = remember { DefaultStudentRepository(dataSource) }

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            val homeViewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
                factory = HomeViewModel.factory(repository)
            )
            HomeScreen(
                uiState = homeViewModel.uiState,
                onOpenDetail = { id ->
                    navController.navigate(Routes.detail(id))
                },
                onOpenProfile = {
                    navController.navigate(Routes.PROFILE)
                },
                onOpenAbout = {
                    navController.navigate(Routes.ABOUT)
                }
            )
        }
        composable(
            route = Routes.DETAIL,
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            val viewModel: DetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
                factory = DetailViewModel.factory(repository)
            )
            LaunchedEffect(studentId) {
                viewModel.loadStudent(studentId)
            }
            DetailScreen(
                uiState = viewModel.uiState,
                onBack = { navController.popBackStack() }
            )
        }
        composable(Routes.PROFILE) {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable(Routes.ABOUT) {
            AboutScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}