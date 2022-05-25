package me.berfini.household

import android.app.Application
import androidx.room.Room
import me.berfini.household.database.CharactersDatabase

class HouseholdApplication: Application() {
    companion object {
        lateinit var database: CharactersDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            CharactersDatabase::class.java,
            "household.db")
            .build()
    }
}