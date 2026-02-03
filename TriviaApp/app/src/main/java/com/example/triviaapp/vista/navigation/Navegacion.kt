package com.example.triviaapp.vista.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.triviaapp.PaginaPrincipal
import com.example.triviaapp.vista.paginas.PaginaFinTrivia
import com.example.triviaapp.vista.paginas.PaginaLista
import com.example.triviaapp.vista.paginas.PaginaLogin
import com.example.triviaapp.vista.paginas.PaginaPerfil
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
                onItemClick = { idTrivia ->
                    navController.navigate("preguntasResponder/$idTrivia")
                }
            )
        }

        composable(Routes.perfil) {
            PaginaPerfil(
                onItemClick = { idTrivia ->
                    navController.navigate("preguntasResponder/$idTrivia")
                },
                onSalida = {navController.navigate("principal")}
            )
        }

        composable(Routes.lista) {
            PaginaLista(
                onItemClick = { idTrivia ->
                    navController.navigate("preguntasResponder/$idTrivia")
                }
            )
        }

        composable(Routes.login) {
            PaginaLogin(
                onItemClick = { navController.navigate("principal") }
            )
        }

        composable(
            route = Routes.paginaRespondePreguntas,
            arguments = listOf(navArgument("idTrivia") { type = NavType.StringType })
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            PaginaResponderPreguntas(
                idTrivia = idTrivia,
                accionFin = {},
                accionCancelar = { navController.navigate("principal") })
        }

        composable(
            route = Routes.paginaFinPreguntas,
            arguments = listOf(navArgument("idTrivia") { type = NavType.StringType })
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            PaginaFinTrivia(
                idTrivia = idTrivia,
                accionSalir = {navController.navigate("principal")}
            )
        }
    }
}
