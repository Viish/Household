package me.berfini.household.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharactersDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}