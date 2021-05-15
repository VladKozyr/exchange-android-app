package com.vlad.kozyr.architecture.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vlad.kozyr.architecture.data.local.db.entity.CurrencyEntity

@Database(entities = [CurrencyEntity::class], version = 1, exportSchema = false)
abstract class CurrencyDataBase : RoomDatabase() {
    abstract val currencyDao: CurrencyDao
}