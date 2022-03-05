package com.example.urlshortener.repository

import com.example.urlshortener.model.ShortLink
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UrlRepository: JpaRepository<ShortLink, String> {


}