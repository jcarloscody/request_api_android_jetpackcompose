package com.jcarloscody.github.muyrecopeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Error

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoryState : State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    list = response.categories,
                    error = null
                )
            } catch (e: Exception){
                _categoriesState.value = _categoriesState
                    .value
                    .copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }


    data class RecipeState(
        val loading: Boolean = false,
        val list: List<Category> = emptyList(),
        val error: String? = null,
    )
}