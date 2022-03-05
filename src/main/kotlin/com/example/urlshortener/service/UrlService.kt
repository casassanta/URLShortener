package com.example.urlshortener.service

import com.example.urlshortener.controller.request.CreateShortLinkRequest
import com.example.urlshortener.model.ShortLink
import com.example.urlshortener.repository.UrlRepository
import org.springframework.stereotype.Service

@Service
class UrlService(
    private val urlRepository: UrlRepository
) {

    fun generateShortLink(url: CreateShortLinkRequest): ShortLink {
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val code = (1..5)
            .map { _ -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("");

        val shortLink = ShortLink(
            destination = url.destination,
            code = code
        )

        urlRepository.save(shortLink)

        return shortLink
    }

}