package romero.jonathan.mipokedex_romerojonathan.model.domain

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import romero.jonathan.mipokedex_romerojonathan.utilities.TipoPokemon


@Immutable
@Serializable
data class Pokemon(
    val nombre: String,
    val Altura: Double,
    val Habilidad: String,
    val Peso: Int,
    val descripcion: String,
    val numPokedex: String,
    val tipo: TipoPokemon,
    @DrawableRes val imgId: Int,
    val favorite: Boolean
)
