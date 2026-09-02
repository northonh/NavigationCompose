package br.edu.ifsp.scl.prdm.sc090578.navigationcompose.navigation

sealed class Screen(val route: String) {
    object SenderScreen : Screen("sender_screen")
    object ReceiverScreen : Screen("receiver_screen")
}