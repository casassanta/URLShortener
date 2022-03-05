package com.example.urlshortener.model

import com.example.urlshortener.controller.response.ShortLinkResponse
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ShortLink (

    @Id
    val code: String,

    val destination: String
){

    fun toShortLinkResponse(): ShortLinkResponse{
        return ShortLinkResponse(
            destination = this.destination,
            shortLink = "https://my.url/" + this.code
        )
    }

}