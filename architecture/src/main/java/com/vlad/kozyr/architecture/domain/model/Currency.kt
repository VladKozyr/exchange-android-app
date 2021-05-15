package com.vlad.kozyr.architecture.domain.model

data class Currency(
    val name: String,
    val rate: Double,
    val percentageChange: Double
)