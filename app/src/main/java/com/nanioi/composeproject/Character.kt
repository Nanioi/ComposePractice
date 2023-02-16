package com.nanioi.composeproject

import java.io.Serializable

data class Character(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val imageUrl: String = ""
): Serializable
