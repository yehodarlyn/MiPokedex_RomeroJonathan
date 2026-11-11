package romero.jonathan.mipokedex_romerojonathan.model.domain

data class PokedexState(
    val team: List<Pokemon> = emptyList(),
    val lasCaptured: Pokemon? = null
)
