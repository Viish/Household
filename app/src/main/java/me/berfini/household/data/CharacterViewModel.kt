package me.berfini.household.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.berfini.household.R
import me.berfini.household.database.CharacterEntity

class CharacterViewModelFactory(private val character: CharacterEntity) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterViewModel(character) as T
    }
}

interface OnCharacterClickedListener {
    fun onCharacterClicked(characterViewModel: CharacterViewModel)
}

class CharacterViewModel(entity: CharacterEntity): ViewModel() {
    val uid: Int

    // Character
    val name = MutableLiveData<String>()
    val folk = MutableLiveData<String>()
    val homeland = MutableLiveData<String>()
    val profession = MutableLiveData<String>()
    val vocation = MutableLiveData<String>()
    val languages = MutableLiveData<String>()
    val picture = MutableLiveData<Int>()
    val background = MutableLiveData<Int>()

    // Society
    val society = MutableLiveData<Int>()
    val art = MutableLiveData<Int>()
    val charme = MutableLiveData<Int>()
    val eloquence = MutableLiveData<Int>()
    val etiquette = MutableLiveData<Int>()
    val grace = MutableLiveData<Int>()

    // Academia
    val academia = MutableLiveData<Int>()
    val care = MutableLiveData<Int>()
    val craft = MutableLiveData<Int>()
    val culture = MutableLiveData<Int>()
    val insight = MutableLiveData<Int>()
    val investigation = MutableLiveData<Int>()

    // War
    val war = MutableLiveData<Int>()
    val athletics = MutableLiveData<Int>()
    val authority = MutableLiveData<Int>()
    val fight = MutableLiveData<Int>()
    val strength = MutableLiveData<Int>()
    val will = MutableLiveData<Int>()

    // Street
    val street = MutableLiveData<Int>()
    val caution = MutableLiveData<Int>()
    val dexterity = MutableLiveData<Int>()
    val elusion = MutableLiveData<Int>()
    val exploration = MutableLiveData<Int>()
    val shoot = MutableLiveData<Int>()

    // Aces
    val aces = MutableLiveData<ArrayList<Boolean>>()

    val wealth = MutableLiveData<Int>()
    val equipement = MutableLiveData<String>()
    val traits = MutableLiveData<String>()
    val moves = MutableLiveData<String>()

    val decorum = MutableLiveData<Int>()
    val turmoil = MutableLiveData<Int>()
    val tension =  MutableLiveData<Int>()
    val condition = MutableLiveData<String>()

    val contracts = MutableLiveData<String>()

    val ttt = MutableLiveData<String>()

    val memoriesP = MutableLiveData<String>()
    val memories1 = MutableLiveData<String>()
    val memories2 = MutableLiveData<String>()
    val memories3 = MutableLiveData<String>()
    val memories4 = MutableLiveData<String>()
    val memories5 = MutableLiveData<String>()
    val memoriesE = MutableLiveData<String>()

    val chapterEvents = MutableLiveData<String>()

    val listener = MutableLiveData<OnCharacterClickedListener>()

    init {
        uid = entity.uid

        name.value = entity.name
        folk.value = entity.folk
        homeland.value = entity.homeland
        profession.value = entity.profession
        vocation.value = entity.vocation
        languages.value = entity.languages
        picture.value = entity.picture

        background.value = when (entity.folk) {
            "Fairy" -> R.drawable.fae_bg
            "Sluagh" -> R.drawable.sluagh_bg
            "Boggart" -> R.drawable.boggart_bg
            else -> R.drawable.sprite_bg
        }

        society.value = entity.society
        art.value = entity.art
        charme.value = entity.charme
        eloquence.value  = entity.eloquence
        etiquette.value  = entity.etiquette
        grace.value  = entity.grace

        academia.value = entity.academia
        care.value = entity.care
        craft.value = entity.craft
        culture.value = entity.culture
        insight.value = entity.insight
        investigation.value = entity.investigation

        war.value = entity.war
        athletics.value = entity.athletics
        authority.value = entity.authority
        fight.value = entity.fight
        strength.value = entity.strength
        will.value = entity.will

        street.value = entity.street
        caution.value = entity.caution
        dexterity.value = entity.dexterity
        elusion.value = entity.elusion
        exploration.value = entity.exploration
        shoot.value = entity.shoot

        aces.value = arrayListOf(entity.heartAce, entity.diamondAce, entity.clubAce, entity.spadeAce, entity.jokerAce)

        wealth.value = entity.wealth
        equipement.value = entity.equipement
        traits.value = entity.traits
        moves.value = entity.moves

        decorum.value = entity.decorum
        turmoil.value = entity.turmoil
        tension.value =  entity.tension
        condition.value = entity.condition

        contracts.value = entity.contracts

        ttt.value = entity.ttt

        memoriesP.value = entity.memoriesP
        memories1.value = entity.memories1
        memories2.value = entity.memories2
        memories3.value = entity.memories3
        memories4.value = entity.memories4
        memories5.value = entity.memories5
        memoriesE.value = entity.memoriesE

        chapterEvents.value = entity.events
    }

    fun toEntity(): CharacterEntity {
        return CharacterEntity(
            uid,
            name.value.orEmpty(),
            folk.value.orEmpty(),
            homeland.value.orEmpty(),
            profession.value.orEmpty(),
            vocation.value.orEmpty(),
            languages.value.orEmpty(),
            picture.value ?: 0,

            society.value ?: 0,
            art.value ?: 0,
            charme.value ?: 0,
            eloquence.value ?: 0,
            etiquette.value ?: 0,
            grace.value ?: 0,

            academia.value ?: 0,
            care.value ?: 0,
            craft.value ?: 0,
            culture.value ?: 0,
            insight.value ?: 0,
            investigation.value ?: 0,

            war.value ?: 0,
            athletics.value ?: 0,
            authority.value ?: 0,
            fight.value ?: 0,
            strength.value ?: 0,
            will.value ?: 0,

            street.value ?: 0,
            caution.value ?: 0,
            dexterity.value ?: 0,
            elusion.value ?: 0,
            exploration.value ?: 0,
            shoot.value ?: 0,

            aces.value?.get(0) ?: false,
            aces.value?.get(1) ?: false,
            aces.value?.get(2) ?: false,
            aces.value?.get(3) ?: false,
            aces.value?.get(4) ?: false,

            wealth.value ?: 0,
            equipement.value.orEmpty(),
            traits.value.orEmpty(),
            moves.value.orEmpty(),

            decorum.value ?: 0,
            turmoil.value ?: 0,
            tension.value ?: 0,
            condition.value.orEmpty(),

            contracts.value.orEmpty(),

            ttt.value.orEmpty(),

            memoriesP.value.orEmpty(),
            memories1.value.orEmpty(),
            memories2.value.orEmpty(),
            memories3.value.orEmpty(),
            memories4.value.orEmpty(),
            memories5.value.orEmpty(),
            memoriesE.value.orEmpty(),

            chapterEvents.value.orEmpty()
        )
    }

    fun toggle(field: MutableLiveData<Int>, value: Int) {
        if (value > (field.value ?: 0)) {
            field.value = value
        } else {
            field.value = value - 1
        }
    }

    fun toggleAce(position: Int) {
        val acesCopy = arrayListOf<Boolean>()
        acesCopy.addAll(aces.value.orEmpty())
        acesCopy[position] = !acesCopy[position]
        aces.value = acesCopy
    }

    fun onClick() {
        listener.value?.onCharacterClicked(this)
    }
}