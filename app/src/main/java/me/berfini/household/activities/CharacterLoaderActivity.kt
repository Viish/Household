package me.berfini.household.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.berfini.household.HouseholdApplication
import me.berfini.household.R
import me.berfini.household.data.*
import me.berfini.household.databinding.CharactersActivityBinding

class CharacterLoaderActivity: AppCompatActivity() {
    private lateinit var binding: CharactersActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.characters_activity)
        binding.lifecycleOwner = this

        val charactersDao = HouseholdApplication.database.characterDao()
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                if (charactersDao.getAll().size < 6) {
                    charactersDao.insert(Hannah)
                    charactersDao.insert(Litha)
                    charactersDao.insert(Pierre)
                    charactersDao.insert(Santiago)
                    charactersDao.insert(Sienna)
                    charactersDao.insert(Tubo)
                }
            }
        }

        val listViewModel = ViewModelProvider(
            this,
            CharactersListViewModelFactory(HouseholdApplication.database.characterDao())
        )[CharactersListViewModel::class.java]
        binding.listViewModel = listViewModel

        listViewModel.charactersList.observe(this) { list ->
            for (character in list.orEmpty()) {
                character.listener.value = object: OnCharacterClickedListener {
                    override fun onCharacterClicked(characterViewModel: CharacterViewModel) {
                        val intent = Intent(this@CharacterLoaderActivity, CharacterActivity::class.java)
                        intent.putExtra("Character_UID", characterViewModel.uid)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}