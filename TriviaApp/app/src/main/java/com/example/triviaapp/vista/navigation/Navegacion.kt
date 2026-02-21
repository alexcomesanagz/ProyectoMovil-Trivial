package com.example.triviaapp.vista.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.triviaapp.PaginaPrincipal
import com.example.triviaapp.viewModels.vm.MainViewModel
import com.example.triviaapp.vista.paginas.PaginaAjustesTrivia
import com.example.triviaapp.vista.paginas.PaginaElegirRespuestas
import com.example.triviaapp.vista.paginas.PaginaFinTrivia
import com.example.triviaapp.vista.paginas.PaginaLista
import com.example.triviaapp.vista.paginas.PaginaLogin
import com.example.triviaapp.vista.paginas.PaginaPerfil
import com.example.triviaapp.vista.paginas.PaginaResponderPreguntas
import com.example.triviaapp.vista.paginas.PaginaSignUp
import androidx.compose.runtime.collectAsState


object Routes {
    const val principal = "principal"
    const val lista = "lista"
    const val login = "login"
    const val perfil = "perfil"

    const val sign = "sign"
    const val paginaAjustes = "ajustes"
    const val paginaCreaPreguntas = "preguntasCrear/{idTrivia}"
    const val paginaRespondePreguntas = "preguntasResponder/{idTrivia}"
    const val paginaFinPreguntas = "preguntasFin/{idTrivia}"
}

/**
 * componente con el que se navega en la aplicación
 * @param navController lo que permite la navegacion entre páginas
 * @param viewMain viewmodel del main, utilizado para saber si ya hay un usuario loguado y para quitar el scaffold y floating buton
 */
@Composable
fun TrivialNavGraph(navController: NavHostController, viewMain: MainViewModel) {

    NavHost(navController = navController, startDestination = Routes.login) {
        composable(Routes.principal) {
            viewMain.ponTodo()
            PaginaPrincipal(
                onItemClick = { idTrivia ->
                    navController.navigate("preguntasResponder/$idTrivia")
                }
            )
        }

        composable(Routes.perfil) {
            viewMain.quitaTodo()
            PaginaPerfil(
                onItemClick = { idTrivia ->
                    navController.navigate("preguntasResponder/$idTrivia")
                },
                onSalida = { navController.navigate("principal") }
            )
        }
        composable(Routes.sign) {
            viewMain.quitaTodo()
            PaginaSignUp(
                onItemClick = {
                    navController.navigate("login")
                },
                onSignUpClick = {navController.navigate("principal")}
            )

        }

        composable(Routes.lista) {
            viewMain.ponTodo()
            PaginaLista(
                onItemClick = { idTrivia ->
                    navController.navigate("preguntasResponder/$idTrivia")
                }
            )
        }

        composable(Routes.login) {
            if(!viewMain.uiState.collectAsState().value.logueado) {
                viewMain.quitaTodo()
                PaginaLogin(
                    onItemClick = { navController.navigate("principal") },
                    onSignUpClick = { navController.navigate("sign") }
                )
            }
            else navController.navigate("principal")
        }

        composable(
            route = Routes.paginaRespondePreguntas,
            arguments = listOf(navArgument("idTrivia") { type = NavType.StringType })
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            viewMain.quitaTodo()
            PaginaResponderPreguntas(
                idTrivia = idTrivia,
                accionFin = { idTrivia -> navController.navigate("preguntasFin/$idTrivia") },
                accionCancelar = { navController.navigate("principal") })
        }

        composable(
            route = Routes.paginaFinPreguntas,
            arguments = listOf(navArgument("idTrivia") { type = NavType.StringType })
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            viewMain.quitaTodo()
            PaginaFinTrivia(
                idTrivia = idTrivia,
                accionSalir = { navController.navigate("principal") }
            )
        }

        composable(Routes.paginaAjustes) {
            viewMain.quitaTodo()
            PaginaAjustesTrivia(
                onClickSalir = { navController.navigate("principal") },
                onClickAceptar = { idTrivia ->
                    navController.navigate("preguntasCrear/$idTrivia")
                }
            )
        }

        composable(
                Routes.paginaCreaPreguntas,
                arguments = listOf(navArgument("idTrivia")
                { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val idTrivia = backStackEntry.arguments?.getString("idTrivia") ?: return@composable
            viewMain.quitaTodo()
            PaginaElegirRespuestas(
                idTrivia = idTrivia,
                onClickSalir = { navController.navigate("principal") },
                onClickAceptar = { navController.navigate("principal") }
            )
        }
    }
}
