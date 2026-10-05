package romero.jonathan.mipokedex_romerojonathan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import romero.jonathan.mipokedex_romerojonathan.PokedexScreen.ui.PokedexScreen
import romero.jonathan.mipokedex_romerojonathan.ui.theme.PokedexTheme
import romero.jonathan.mipokedex_romerojonathan.PokedexScreen.ui.PokedexScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme { PokedexScreen() }
        }
    }
}
