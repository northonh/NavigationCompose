package br.edu.ifsp.scl.prdm.sc090578.navigationcompose.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.edu.ifsp.scl.prdm.sc090578.navigationcompose.ui.composable.ReceiverScreen
import br.edu.ifsp.scl.prdm.sc090578.navigationcompose.ui.composable.SenderScreen
import kotlin.collections.listOf

@Composable
fun MainNavHost(navHostController: NavHostController, modifier: Modifier) {
    NavHost(navController = navHostController, startDestination = Screen.SenderScreen.route) {
        // Criando as rotas do grafo
        composable(route = Screen.SenderScreen.route) {
            // Enviando lambda no onSendClick que deve ser executado ao clicar no botão Send
            SenderScreen(modifier = modifier) { textoToSend ->
                navHostController.navigate("${Screen.ReceiverScreen.route}/${Uri.encode(textoToSend)}")
            }
        }
        // O parâmetro textReceived será passado de SendScreen para ReceiverScreen como argumento da rota
        composable(
            route = "${Screen.ReceiverScreen.route}/{textReceived}",
            arguments = listOf(
                navArgument("textReceived") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            // Recuperando o argumento passado na rota e passando para o ReceiverScreen como argumento
            ReceiverScreen(
                textReceived = backStackEntry.arguments?.getString("textReceived") ?: "",
                modifier = modifier
            )
        }
    }
}