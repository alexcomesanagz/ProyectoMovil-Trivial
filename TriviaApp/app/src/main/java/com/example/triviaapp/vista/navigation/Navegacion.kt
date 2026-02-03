package com.example.triviaapp.vista.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.triviaapp.PaginaPrincipal
import com.example.triviaapp.vista.paginas.PaginaAjustesTrivia
import com.example.triviaapp.vista.paginas.PaginaElegirRespuestas
import com.example.triviaapp.vista.paginas.PaginaResponderPreguntas


object Routes {
    const val principal = "principal"
    const val lista = "lista"
    const val login = "login"
    const val perfil = "perfil"
    const val paginaAjustes = "ajustes"
    const val paginaCreaPreguntas = "preguntasCrear/{idTrivia}"
    const val paginaRespondePreguntas = "preguntasResponder/{idTrivia}"
    const val paginaFinPreguntas = "preguntasFin/{idTrivia}"
}

@Composable
fun PokemonNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.principal) {
        composable(Routes.principal) {
            PaginaPrincipal(
                onItemClick =  { idTrivia ->
                    navController.navigate("preguntas/$idTrivia")
                }
            )
        }
        composable(
            route = Routes.paginaRespondePreguntas,
            arguments = listOf(navArgument("idTrivia") { type = NavType.StringType })
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            PaginaResponderPreguntas(idTrivia= idTrivia)
        }

        composable(Routes.paginaAjustes) {
            PaginaAjustesTrivia(
                onClickSalir =  { navController.navigate("principal") },
                onClickAceptar =  { idTrivia ->
                    navController.navigate("preguntasCrear/$idTrivia")
                }
            )
        }

        composable(Routes.paginaCreaPreguntas,arguments = listOf(navArgument("idTrivia") { type = NavType.StringType })
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            PaginaElegirRespuestas(
                idTrivia = idTrivia,
                onClickSalir =  { navController.navigate("principal") },
                onClickAceptar =  { navController.navigate("principal") }
            )
        }
    }
}
