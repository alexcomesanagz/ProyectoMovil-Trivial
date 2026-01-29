package com.example.triviaapp.vista.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


//object Routes {
//    const val List = "list"
//    const val Detail = "detail/{pokemonId}"
//}
//
//@Composable
//fun PokemonNavGraph() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Routes.List) {
//        composable(Routes.List) {
//            PokemonListScreen { pokemonId ->
//                navController.navigate("detail/$pokemonId")
//            }
//        }
//        composable(
//            route = Routes.Detail,
//            arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
//        ) { backStackEntry ->
//            val pokemonId = backStackEntry.arguments?.getInt("pokemonId") ?: return@composable
//            PokemonDetailScreen(pokemonId = pokemonId)
//        }
//    }
//}
