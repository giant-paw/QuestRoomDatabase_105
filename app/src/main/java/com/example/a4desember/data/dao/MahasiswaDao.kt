package com.example.a4desember.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.a4desember.data.entity.Mahasiswa

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}