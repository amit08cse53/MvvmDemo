package com.learn2crack.retrofitkotlin.model

import com.squareup.moshi.Json

data class Androidsdf(
        @Json(name = "version") var version: String,
        @Json(name = "name") var name: String,
        @Json(name = "apiLevel") var apiLevel: String
)
