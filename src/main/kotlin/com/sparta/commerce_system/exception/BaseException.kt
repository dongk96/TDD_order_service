package com.sparta.commerce_system.exception

import com.sparta.commerce_system.web.response.ApiResponseCode


abstract class BaseException: RuntimeException() {
    open lateinit var code: ApiResponseCode
    override lateinit var message: String
}