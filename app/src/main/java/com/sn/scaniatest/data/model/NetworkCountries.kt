package com.sn.scaniatest.data.model


import com.google.gson.annotations.SerializedName
import com.sn.scaniatest.domain.model.*

data class NetworkCountries(
    @SerializedName("name")
    val name: Name?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("population")
    val population: Int?,
    @SerializedName("timezones")
    val timezones: List<String>?,
    @SerializedName("capital")
    val capital: List<String>,
    @SerializedName("flags")
    val flags: Flags?,
    @SerializedName("startOfWeek")
    val startOfWeek: String?
) {
    data class Name(
        @SerializedName("common")
        val common: String,
        @SerializedName("official")
        val official: String,
        @SerializedName("nativeName")
        val nativeName: NativeName
    ) {
        data class NativeName(
            @SerializedName("eng")
            val eng: Eng?
        ) {
            data class Eng(
                @SerializedName("official")
                val official: String?,
                @SerializedName("common")
                val common: String?
            )
        }
    }

    data class Flags(
        @SerializedName("png")
        val png: String?,
        @SerializedName("svg")
        val svg: String?
    )
    fun asCountries(): Countries = Countries(

        name = Name(
            common = name?.common,
            official = name?.official,
            nativeName = NativeName(
                eng = EngX(
                    common = name?.nativeName?.eng?.common,
                    official = name?.nativeName?.eng?.official
                )
            )
        ),
        capital = capital,
        flag = flag,
        flags = com.sn.scaniatest.domain.model.Flags(png = flags?.png, flags?.svg),
        population = population,
        region = region,
        timezones = timezones,
        startOfWeek = startOfWeek

    )
}