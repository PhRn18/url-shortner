package com.project.urlshortner.service

import com.project.urlshortner.model.GenerateUrlRequest
import com.project.urlshortner.model.GenerateUrlResponse

interface UrlShortnerService {
    fun generateUrl(generateUrlRequest: GenerateUrlRequest): GenerateUrlResponse
    fun resolve(hash:String):String
}