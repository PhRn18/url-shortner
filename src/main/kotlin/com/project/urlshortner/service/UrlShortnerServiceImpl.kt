package com.project.urlshortner.service

import com.project.urlshortner.exception.HashNotFoundException
import com.project.urlshortner.model.GenerateUrlRequest
import com.project.urlshortner.model.GenerateUrlResponse
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.math.BigInteger
import java.security.MessageDigest

@Service
class UrlShortnerServiceImpl(
    private val redis:RedisTemplate<String,String>
):UrlShortnerService {
    private val digest = MessageDigest.getInstance("SHA-256")

    override fun generateUrl(generateUrlRequest: GenerateUrlRequest): GenerateUrlResponse {
        val url = generateUrlRequest.url
        val expirationTime = generateUrlRequest.expirationTime
        val hash = generateHash(url)
        redis.opsForValue().set(hash,url, expirationTime)
        return GenerateUrlResponse(hash)
    }

    override fun resolve(hash: String): String {
        return redis.opsForValue().get(hash) ?: throw HashNotFoundException(hash)
    }

    private fun generateHash(url:String, length:Int=6):String{
        val bytes = digest.digest(url.toByteArray())
        val hash = String.format("%32x",BigInteger(1,bytes))
        return hash.take(length)
    }
}