package com.example.mod4demo3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RockViewModel(
    private val rockRepository: RockRepository
) : ViewModel() {

    private val _bands = MutableStateFlow<List<String>>(emptyList())
    val bands = _bands.asStateFlow()

    init {
        _bands.value = rockRepository.getAllRockBand()
    }

    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
//                val application = checkNotNull(extras[APPLICATION_KEY])
//                // Create a SavedStateHandle for this ViewModel from extras
//                val savedStateHandle = extras.createSavedStateHandle()

                return RockViewModel(
                    RockRepository()
                ) as T
            }
        }
    }


}