package com.example.urlshortener.controller

import com.example.urlshortener.controller.request.CreateShortLinkRequest
import com.example.urlshortener.controller.response.ShortLinkResponse
import com.example.urlshortener.service.UrlService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlController(
    private val urlService: UrlService
) {

    @PostMapping("api/longlinks")
    fun shortenerUrl(@RequestBody url: CreateShortLinkRequest): ShortLinkResponse{
        return urlService.generateShortLink(url).toShortLinkResponse()
    }

    @PostMapping("api/shortlinks")
    fun getLongLink(@RequestBody shortLink: String): String{
        return urlService.getLongLink(shortLink)
    }
}