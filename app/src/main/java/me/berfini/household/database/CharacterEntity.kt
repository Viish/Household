package me.berfini.household.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "folk") val folk: String,
    @ColumnInfo(name = "homeland") val homeland: String,
    @ColumnInfo(name = "profession") val profession: String,
    @ColumnInfo(name = "vocation") val vocation: String,
    @ColumnInfo(name = "languages") val languages: String,
    @ColumnInfo(name = "picture") val picture: Int,

    @ColumnInfo(name = "society") val society: Int,
    @ColumnInfo(name = "art") val art: Int,
    @ColumnInfo(name = "charme") val charme: Int,
    @ColumnInfo(name = "eloquence") val eloquence: Int,
    @ColumnInfo(name = "etiquette") val etiquette: Int,
    @ColumnInfo(name = "grace") val grace: Int,
    @ColumnInfo(name = "academia") val academia: Int,
    @ColumnInfo(name = "care") val care: Int,
    @ColumnInfo(name = "craft") val craft: Int,
    @ColumnInfo(name = "culture") val culture: Int,
    @ColumnInfo(name = "insight") val insight: Int,
    @ColumnInfo(name = "investigation") val investigation: Int,
    @ColumnInfo(name = "war") val war: Int,
    @ColumnInfo(name = "athletics") val athletics: Int,
    @ColumnInfo(name = "authority") val authority: Int,
    @ColumnInfo(name = "fight") val fight: Int,
    @ColumnInfo(name = "strength") val strength: Int,
    @ColumnInfo(name = "will") val will: Int,
    @ColumnInfo(name = "street") val street: Int,
    @ColumnInfo(name = "caution") val caution: Int,
    @ColumnInfo(name = "dexterity") val dexterity: Int,
    @ColumnInfo(name = "elusion") val elusion: Int,
    @ColumnInfo(name = "exploration") val exploration: Int,
    @ColumnInfo(name = "shoot") val shoot: Int,

    @ColumnInfo(name = "heartAce") val heartAce: Boolean,
    @ColumnInfo(name = "diamondAce") val diamondAce: Boolean,
    @ColumnInfo(name = "clubAce") val clubAce: Boolean,
    @ColumnInfo(name = "spadeAce") val spadeAce: Boolean,
    @ColumnInfo(name = "jokerAce") val jokerAce: Boolean,
    @ColumnInfo(name = "wealth") val wealth: Int,
    @ColumnInfo(name = "equipement") val equipement: String,
    @ColumnInfo(name = "traits") val traits: String,
    @ColumnInfo(name = "moves") val moves: String,

    @ColumnInfo(name = "decorum") val decorum: Int,
    @ColumnInfo(name = "turmoil") val turmoil: Int,
    @ColumnInfo(name = "tension") val tension: Int,
    @ColumnInfo(name = "condition") val condition: String,
    @ColumnInfo(name = "contracts") val contracts: String,
    @ColumnInfo(name = "ttt") val ttt: String,

    @ColumnInfo(name = "memoriesP") val memoriesP: String,
    @ColumnInfo(name = "memories1") val memories1: String,
    @ColumnInfo(name = "memories2") val memories2: String,
    @ColumnInfo(name = "memories3") val memories3: String,
    @ColumnInfo(name = "memories4") val memories4: String,
    @ColumnInfo(name = "memories5") val memories5: String,
    @ColumnInfo(name = "memoriesE") val memoriesE: String,
    @ColumnInfo(name = "events") val events: String,
)