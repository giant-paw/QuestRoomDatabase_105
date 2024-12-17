package com.example.a4desember.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a4desember.ui.view.mahasiswa.DestinasiInsert
import com.example.a4desember.ui.view.mahasiswa.DetailMhsView
import com.example.a4desember.ui.view.mahasiswa.HomeMhsView
import com.example.a4desember.ui.view.mahasiswa.InsertMhsView
import com.example.a4desember.ui.view.mahasiswa.UpdateMhsView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = DestinasiInsert.route) {
        composable(
            route = AlamatNavigasi.DestinasiHome.route
        ) {
            HomeMhsView(
                onDetailClick = { nim ->
                    navController.navigate("${AlamatNavigasi.DestinasiDetail.route}/$nim")
                    println(
                        "PengelolaHalaman: nim = $nim"
                    )
                },
                onAddMhs = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier
            )
        }

        composable(
            route = DestinasiInsert.route
        ){
            InsertMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier,
            )
        }

        composable(
            AlamatNavigasi.DestinasiDetail.routesWithArg,
            arguments = listOf(
                navArgument(AlamatNavigasi.DestinasiDetail.NIM) {
                    type = NavType.StringType
                }
            )
        ){
            val nim = it.arguments?.getString(AlamatNavigasi.DestinasiDetail.NIM)

            nim?.let { nim ->
                DetailMhsView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${AlamatNavigasi.DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(
            AlamatNavigasi.DestinasiUpdate.routesWithArg,
            arguments = listOf(
                navArgument(AlamatNavigasi.DestinasiUpdate.NIM) {
                    type = NavType.StringType
                }
            )
        ){

            UpdateMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier,
            )
        }
    }
}