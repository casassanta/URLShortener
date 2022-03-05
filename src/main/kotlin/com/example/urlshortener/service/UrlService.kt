package com.example.urlshortener.service

import com.example.urlshortener.controller.request.UrlShortenerRequest
import org.springframework.stereotype.Service

@Service
class UrlService {

    fun generateShortenerUrl(url: UrlShortenerRequest): String{
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val myUrl = "https://my.url/"
        val shortenerUrlCode = (1..8)
            .map { _ -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("");

        return myUrl + shortenerUrlCode
    }

}