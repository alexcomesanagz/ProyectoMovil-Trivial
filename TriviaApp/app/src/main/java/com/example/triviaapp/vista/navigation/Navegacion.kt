package com.example.triviaapp.vista.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.triviaapp.PaginaPrincipal
import com.example.triviaapp.vista.paginas.PaginaResponderPreguntas


object Routes {
    const val principal = "principal"
    const val lista = "lista"
    const val login = "login"
    const val perfil = "perfil"
    const val paginaAjustes = "ajustes"
    const val paginaCreaPreguntas = "preguntas/{idTrivia}"
    const val paginaRespondePreguntas = "preguntas/{idTrivia}"
    const val paginaFinPreguntas = "preguntas/{idTrivia}"
}

@Composable
fun PokemonNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.principal) {
        composable(Routes.principal) {
            PaginaPrincipal(onItemClick =  { idTrivia ->
                navController.navigate("preguntas/$idTrivia")
            }
        }
        composable(
            route = Routes.paginaRespondePreguntas,
            arguments = listOf(navArgument("idTrivia") { type = NavType.StringType })
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            PaginaResponderPreguntas(idTrivia= idTrivia)
        }
    }
}
