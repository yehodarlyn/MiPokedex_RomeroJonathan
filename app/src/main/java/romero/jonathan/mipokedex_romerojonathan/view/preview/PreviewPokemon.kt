package romero.jonathan.mipokedex_romerojonathan.view.preview

import romero.jonathan.mipokedex_romerojonathan.R
import romero.jonathan.mipokedex_romerojonathan.model.domain.Pokemon
import romero.jonathan.mipokedex_romerojonathan.utilities.TipoPokemon

internal val previewPokemon = Pokemon(
    nombre = "Pikachu", Altura = 0.4, Habilidad = "Electricidad estática",
    Peso = 6, descripcion = "Pokémon de ejemplo", numPokedex = "#0025",
    tipo = TipoPokemon.ELECTRICO, imgId = R.drawable.pikachu, favorite = true
)
internal val previewPokemones = List(4) { previewPokemon }
