package com.sparta.commerce_system.exception

import com.sparta.commerce_system.web.response.ApiResponseCode


class AcceptDeniedException(override var message: String): BaseException() {
    override var code: ApiResponseCode = ApiResponseCode.NOT_ACCEPTABLE
}