package com.vlad.kozyr.architecture.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey val name: String,
    val rate: Double,
    val rateDayBefore: Double
)