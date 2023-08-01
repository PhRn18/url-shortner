package com.project.urlshortner.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(HashNotFoundException::class)
    fun handleHashNotFoundException(hashNotFoundException: HashNotFoundException): ResponseEntity<Map<String, String>> {
        val status = HttpStatus.NOT_FOUND
        val response = mapOf(
            "message" to "${hashNotFoundException.message}",
            "status" to "${status}"
        )
        return ResponseEntity.status(status).body(response)
    }
}