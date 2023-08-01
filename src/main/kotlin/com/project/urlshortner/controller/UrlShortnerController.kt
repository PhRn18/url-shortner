package com.project.urlshortner.controller

import com.project.urlshortner.model.GenerateUrlRequest
import com.project.urlshortner.model.GenerateUrlResponse
import com.project.urlshortner.service.UrlShortnerService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/")
class UrlShortnerController(
    private val urlShortnerService: UrlShortnerService
) {

    @PostMapping
    fun generateUrl(@RequestBody generateUrlRequest: GenerateUrlRequest):ResponseEntity<GenerateUrlResponse>{
        val result = urlShortnerService.generateUrl(generateUrlRequest)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/{hash}")
    fun redirect(@PathVariable hash:String):ResponseEntity<HttpStatus>{
        val result = urlShortnerService.resolve(hash)
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .location(URI.create(result))
            .header(HttpHeaders.CONNECTION,"close")
            .build()
    }

}