package cl.random.test.models

import java.io.Serializable

data class Country(
    val name: String,
    val capital: String,
    val flag: String,
    val area: String,
    var population: Int
) : Serializable