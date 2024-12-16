package com.example.a4desember.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a4desember.KrsApp

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            MahasiswaViewModel(
                krsApp().containerApp.repositoryMhs
            )
        }

        initializer {
            HomeMhsViewModel(
                krsApp().containerApp.repositoryMhs
            )
        }

        initializer {
            DetailMhsViewModel(
                createSavedStateHandle(),
                krsApp().containerApp.repositoryMhs
            )
        }

        initializer {
            UpdateMhsViewModel(
                createSavedStateHandle(),
                krsApp().containerApp.repositoryMhs
            )
        }
    }
}

fun CreationExtras.krsApp(): KrsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KrsApp)