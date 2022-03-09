package com.example.urlshortener.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(InvalidShortLinkException::class)
    fun handleInvalidShortLinkException(e: InvalidShortLinkException): ResponseEntity<ErrorResponse>{
        return ResponseEntity<ErrorResponse>(
            ErrorResponse("Invalid short link"),
            HttpStatus.BAD_REQUEST
        )
    }
}

data class ErrorResponse(
    val message: String
)