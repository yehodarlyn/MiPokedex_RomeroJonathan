package romero.jonathan.mipokedex_romerojonathan.utilities

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Amarillo
import romero.jonathan.mipokedex_romerojonathan.ui.theme.BlackBajti
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Cafe
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Morado
import romero.jonathan.mipokedex_romerojonathan.ui.theme.OffWhite
import romero.jonathan.mipokedex_romerojonathan.ui.theme.Verde


@Serializable
enum class TipoPokemon(val etiqueta: String, val fondo: Color, val texto: Color) {
    ELECTRICO("Eléctrico", Amarillo, BlackBajti),
    LUCHA_ACERO("Lucha / Acero", Cafe, BlackBajti),
    PLANTA_VENENO("Planta / Veneno", Morado, OffWhite),
    VENENO("Veneno", Verde, OffWhite)
}
