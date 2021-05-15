package com.vlad.kozyr.architecture.data.main.mapper

import com.vlad.kozyr.architecture.core.Mapper
import com.vlad.kozyr.architecture.data.local.db.entity.CurrencyEntity
import com.vlad.kozyr.architecture.domain.model.Currency

class CurrencyMapper : Mapper<Currency, CurrencyEntity> {
    override fun toModel(entity: CurrencyEntity): Currency {
        return with(entity) {
            Currency(
                name = name,
                rate = rate,
                percentageChange = rateDayBefore
            )
        }
    }

    override fun fromModel(model: Currency): CurrencyEntity {
        return with(model) {
            CurrencyEntity(
                name = name,
                rate = rate,
                rateDayBefore = percentageChange
            )
        }
    }
}