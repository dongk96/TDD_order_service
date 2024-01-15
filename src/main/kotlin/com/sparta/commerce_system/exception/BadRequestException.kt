package com.sparta.commerce_system.exception

import com.sparta.commerce_system.web.response.ApiResponseCode


class BadRequestException(override var message: String): BaseException() {
    override var code: ApiResponseCode = ApiResponseCode.BAD_REQUEST
}