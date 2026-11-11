package romero.jonathan.mipokedex_romerojonathan.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStore

import kotlinx.coroutines.flow.Flow
import romero.jonathan.mipokedex_romerojonathan.model.domain.CompanionData
import romero.jonathan.mipokedex_romerojonathan.model.domain.Pokemon
import romero.jonathan.mipokedex_romerojonathan.model.preferences.CompanionSerializer


val Context.companionDataStore: DataStore<CompanionData> by dataStore(
    fileName = "pokemon.json",
    serializer = CompanionSerializer,
    corruptionHandler = ReplaceFileCorruptionHandler{ CompanionData()}
)

class CompanionDataStore(private val context: Context) {

    val companionFlow: Flow<CompanionData> = context.companionDataStore.data

    suspend fun saveCompanion(pokemon: Pokemon) {
        context.companionDataStore.updateData { current ->
            if (current.pokemon?.numPokedex == pokemon.numPokedex) current
            else CompanionData(pokemon = pokemon, selectedAtMillis = System.currentTimeMillis())
        }
    }
}
