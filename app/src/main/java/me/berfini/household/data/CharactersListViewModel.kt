package me.berfini.household.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.berfini.household.database.CharacterDao
import me.berfini.household.database.CharacterEntity

class CharactersListViewModelFactory(private val dao: CharacterDao) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersListViewModel(dao) as T
    }
}

class CharactersListViewModel(dao: CharacterDao): ViewModel() {
    val characters = MutableLiveData<List<CharacterEntity>>()

    val charactersList = MutableLiveData<List<CharacterViewModel>>()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dbList = dao.getAll()
                characters.postValue(dbList)

                withContext(Dispatchers.Main) {
                    val list = arrayListOf<CharacterViewModel>()
                    for (character in dbList) {
                        list.add(CharacterViewModel(character))
                    }
                    charactersList.value = list
                }
            }
        }
    }
}