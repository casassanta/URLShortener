package com.example.urlshortener.controller

import com.example.urlshortener.controller.request.UrlShortenerRequest
import com.example.urlshortener.service.UrlService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlController(
    private val urlService: UrlService
) {

    @PostMapping("api/shorteners")
    fun shortenerUrl(@RequestBody url: UrlShortenerRequest): String{
        return urlService.generateShortenerUrl(url)
    }
}