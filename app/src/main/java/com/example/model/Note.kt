package com.example.model

import java.util.UUID

data class Note(
    val id :UUID=UUID.randomUUID(),
val title:String,
    val description:String,


)