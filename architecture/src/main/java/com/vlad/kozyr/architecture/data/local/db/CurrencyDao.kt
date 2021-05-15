package com.vlad.kozyr.architecture.data.local.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vlad.kozyr.architecture.data.local.db.entity.CurrencyEntity

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency")
    fun observeAllByName(): LiveData<List<CurrencyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: List<CurrencyEntity>)

    @Update
    suspend fun update(entity: CurrencyEntity): Int

    @Update
    suspend fun update(entities: List<CurrencyEntity>): Int
}