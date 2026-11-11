package romero.jonathan.mipokedex_romerojonathan.navigation

import androidx.navigation.toRoute
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import romero.jonathan.mipokedex_romerojonathan.model.domain.Pokemon
import romero.jonathan.mipokedex_romerojonathan.view.screens.LoginScreen
import romero.jonathan.mipokedex_romerojonathan.view.screens.MenuPokedexScreen
import romero.jonathan.mipokedex_romerojonathan.view.screens.PokemonDetailScreen
import romero.jonathan.mipokedex_romerojonathan.view.screens.PokemonHuntScreen
import romero.jonathan.mipokedex_romerojonathan.view.screens.ProfileScreen
import romero.jonathan.mipokedex_romerojonathan.viewmodel.UserViewModel


fun NavGraphBuilder.loginDestination(
    userViewModel: UserViewModel,
    onLoginSuccess: () -> Unit
) {
    composable<Routes.Login> {
        LoginScreen(viewModel = userViewModel, onLoginSuccess = onLoginSuccess)
    }
}

fun NavGraphBuilder.menuPokedexDestination(
    userViewModel: UserViewModel,
    onPokemonClick: (Pokemon) -> Unit,
    onNavigateToHunt: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onLogout: () -> Unit
) {
    composable<Routes.MenuPokedex> {
        MenuPokedexScreen(
            userViewModel = userViewModel,
            onPokemonClick = onPokemonClick,
            onNavigateToHunt = onNavigateToHunt,
            onNavigateToProfile = onNavigateToProfile,
            onLogout = onLogout
        )
    }
}

fun NavGraphBuilder.pokemonDetailDestination(onPokemonNotFound: () -> Unit) {
    composable<Routes.PokemonDetail> { entry ->
        val route = entry.toRoute<Routes.PokemonDetail>()
        PokemonDetailScreen(numPokedex = route.numPokedex, onPokemonNotFound = onPokemonNotFound)
    }
}

fun NavGraphBuilder.pokemonHuntDestination() {
    composable<Routes.PokemonHunt> {
        PokemonHuntScreen()
    }
}
fun NavGraphBuilder.profileDestination(userViewModel: UserViewModel) {
    composable<Routes.Profile> {
        ProfileScreen(userViewModel = userViewModel)
    }
}

