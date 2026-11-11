package romero.jonathan.mipokedex_romerojonathan.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import romero.jonathan.mipokedex_romerojonathan.model.data.CompanionDataStore
import romero.jonathan.mipokedex_romerojonathan.model.data.PokemonRepositorio
import romero.jonathan.mipokedex_romerojonathan.model.domain.Pokemon

class PokemonDetailViewModel(
    private val numPokedex: String,
    private val companionDataStore: CompanionDataStore
) : ViewModel() {


    val pokemon: Pokemon? = PokemonRepositorio.getPokemonByNumber(numPokedex)

    val isCompanion: StateFlow<Boolean> = companionDataStore.companionFlow
        .map { it.pokemon?.numPokedex == numPokedex }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    var showSelectedMessage by mutableStateOf(false)
        private set

    fun selectCompanion() {
        val selected = pokemon ?: return
        viewModelScope.launch {
            companionDataStore.saveCompanion(selected)
            showSelectedMessage = true
        }
    }

    fun messageShown() {
        showSelectedMessage = false
    }

    companion object {
        fun factory(numPokedex: String): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                PokemonDetailViewModel(
                    numPokedex = numPokedex,
                    companionDataStore = CompanionDataStore(application)
                )
            }
        }
    }
}