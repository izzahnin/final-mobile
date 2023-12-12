package com.d121211103.book.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211103.book.MyApplication
import com.d121211103.book.data.models.Book
import com.d121211103.book.data.repository.BooksRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class  Success(val books: List<Book>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val booksRepository: BooksRepository): ViewModel() {

//    initial state
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
    private set

    fun getBooks() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = booksRepository.getBooks()
            mainUiState = MainUiState.Success(result.results.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    init {
        getBooks()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val booksRepository = application.container.booksRepository
                MainViewModel(booksRepository)
            }
        }
    }
}