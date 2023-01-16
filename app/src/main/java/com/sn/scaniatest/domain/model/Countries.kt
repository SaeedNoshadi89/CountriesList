package com.sn.scaniatest.domain.model

data class Countries(
    val capital: List<String>? = null,
    val flag: String? = null,
    val flags: Flags? = null,
    val name: Name? = null,
    val population: Int? = null,
    val startOfWeek: String? = null,
    val region: String? = null,
    val timezones: List<String>? = null,
)

data class Flags(
    val png: String?,
    val svg: String?
)


data class Name(
    val common: String?,
    val nativeName: NativeName?,
    val official: String?
)

data class EngX(
    val common: String?,
    val official: String?
)

data class NativeName(
    val eng: EngX?
)
