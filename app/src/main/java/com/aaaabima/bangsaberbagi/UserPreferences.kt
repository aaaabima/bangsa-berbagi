package com.aaaabima.bangsaberbagi

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences private constructor(private val database: DataStore<Preferences>) {
    fun getUserSession(): Flow<UserSession> {
        return database.data.map { preferences ->
            UserSession (
            preferences[ID_KEY] ?: "",
            preferences[TOKEN_KEY] ?: "",
            preferences[STATE_KEY] ?: false
            )
        }
    }

    suspend fun saveUserSession(session: UserSession) {
        database.edit { preferences ->
            preferences[ID_KEY] = session.id
            preferences[TOKEN_KEY] = session.token
            preferences[STATE_KEY] = session.isLoggedIn
        }
    }

    suspend fun login() {
        database.edit { preferences ->
            preferences[STATE_KEY] = true
        }
    }

    suspend fun logout() {
        database.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreferences? = null
        private val ID_KEY = stringPreferencesKey("id")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(database: DataStore<Preferences>): UserPreferences {
            return INSTANCE?: synchronized(this) {
                val instance = UserPreferences(database)
                INSTANCE = instance
                instance
            }
        }
    }
}