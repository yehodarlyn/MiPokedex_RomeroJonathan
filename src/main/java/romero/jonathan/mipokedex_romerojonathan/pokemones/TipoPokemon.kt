package romero.jonathan.mipokedex_romerojonathan.pokemones

import androidx.compose.ui.graphics.Color
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Amarillo
import romero.jonathan.mipokedex_romerojonathan.ui.theme.BlackBajti
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Cafe
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Morado
import romero.jonathan.mipokedex_romerojonathan.ui.theme.OffWhite
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Verde

enum class TipoPokemon(val etiqueta: String, val fondo: Color, val texto: Color) {
    ELECTRICO("Eléctrico", Amarillo, BlackBajti),
    LUCHA_ACERO("Lucha / Acero", Cafe, BlackBajti),
    PLANTA_VENENO("Planta / Veneno", Morado, OffWhite),
    VENENO("Veneno", Verde, OffWhite)
}