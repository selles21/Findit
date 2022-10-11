package com.selles.ifindit.data.error

private const val CONNECTION_ERROR_MESSAGE = "Check your internet connection"

class NetworkException(
    override val message: String = CONNECTION_ERROR_MESSAGE
) : Exception()