package com.example.a4desember.dependeciesinjection

import android.content.Context
import com.example.a4desember.data.database.KrsDatabase
import com.example.a4desember.repository.LocalRepositoryMhs
import com.example.a4desember.repository.RepositoryMhs

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}