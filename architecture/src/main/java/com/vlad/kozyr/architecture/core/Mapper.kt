package com.vlad.kozyr.architecture.core

interface Mapper<MODEL, ENTITY> {
    fun toModel(entity: ENTITY): MODEL
    fun fromModel(model: MODEL): ENTITY
}
