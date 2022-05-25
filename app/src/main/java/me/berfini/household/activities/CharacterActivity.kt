package me.berfini.household.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.berfini.household.HouseholdApplication
import me.berfini.household.R
import me.berfini.household.data.*
import me.berfini.household.databinding.CharacterActivityBinding

class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: CharacterActivityBinding
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.character_activity)
        binding.lifecycleOwner = this

        val listViewModel = ViewModelProvider(
            this,
            CharactersListViewModelFactory(HouseholdApplication.database.characterDao())
        )[CharactersListViewModel::class.java]

        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        val selectedCharacterUid = intent.getIntExtra("Character_UID", 0)

        listViewModel.charactersList.observe(this) { list ->
            val viewModel =  list.find { character ->
                character.uid == selectedCharacterUid
            }
            if (viewModel != null) {
                sharedViewModel.selectedViewModel = viewModel
                findNavController(R.id.main_nav_controller).navigate(R.id.action_loadingFragment_to_characterFragment)
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val navController = findNavController(R.id.main_nav_controller)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    override fun onPause() {
        val updatedEntity = sharedViewModel.selectedViewModel.toEntity()
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                HouseholdApplication.database.characterDao().update(updatedEntity)
            }
        }

        super.onPause()
    }
}