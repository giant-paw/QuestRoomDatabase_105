package com.example.a4desember.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.a4desember.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface MahasiswaDao {
    @Query("select * from mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>

    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM mahasiswa where nim = :nim")
    fun getMahasiswa(nim: String): Flow<Mahasiswa>

    @Delete
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa)
    @Update
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa)
}