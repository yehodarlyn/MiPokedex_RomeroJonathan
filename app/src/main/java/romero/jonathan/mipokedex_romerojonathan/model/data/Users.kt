package romero.jonathan.mipokedex_romerojonathan.model.data

import android.content.Context
import romero.jonathan.mipokedex_romerojonathan.model.domain.User
import romero.jonathan.mipokedex_romerojonathan.model.preferences.ARCHIVO
import romero.jonathan.mipokedex_romerojonathan.model.preferences.POKEMON_DISPLAY
import romero.jonathan.mipokedex_romerojonathan.model.preferences.USER
import romero.jonathan.mipokedex_romerojonathan.model.preferences.USERNAME


class Users(context: Context) {

    val users = listOf(
        User(email = "ash@pokemon.com", password = "pikachu", name = "Ash Ketchum"),
        User(email = "misty@pokemon.com", password = "staryu", name = "Misty"),
        User(email = "brock@pokemon.com", password = "onix", name = "Brock")
    )

    val shared = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE)

    fun getUserByMail(mail: String): User? {
        return users.find { it.email.equals(mail, ignoreCase = true) }
    }

    fun loginService(email: String, password: String): User? {
        val user = getUserByMail(email)
        if (user != null && user.password == password) {
            saveUser(user.email, user.name)
            return user
        }
        return null
    }

    fun saveUser(user: String, name: String) {
        val editor = shared.edit()
        editor.putString(USER, user)
        editor.putString(USERNAME, name)
        editor.apply()
    }

    fun isLoggedIn(): Boolean {
        val user = shared.getString(USER, null)
        val username = shared.getString(USERNAME, null)

        if (user != null && username != null) {
            return true
        }
        return false
    }

    fun logout() {
        val editor = shared.edit()
        editor.putString(USER, null)
        editor.putString(USERNAME, null)
        editor.apply()
    }

    fun saveDisplayPreference(grid: Boolean) {
        val editor = shared.edit()
        editor.putBoolean(POKEMON_DISPLAY, grid)
        editor.apply()
    }

    fun isGridDisplay(): Boolean {
        return shared.getBoolean(POKEMON_DISPLAY, false)
    }
}
