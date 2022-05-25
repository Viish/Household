package me.berfini.household.database

import androidx.room.*

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters")
    fun getAll(): List<CharacterEntity>

    @Query("SELECT * FROM characters WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): CharacterEntity

    @Insert
    suspend fun insert(vararg character: CharacterEntity)

    @Update
    suspend fun update(vararg character: CharacterEntity)

    @Delete
    suspend fun delete(character: CharacterEntity)
}