package com.project.urlshortner.model

data class GenerateUrlRequest(
    val url:String,
    val expirationTime:Long
)
