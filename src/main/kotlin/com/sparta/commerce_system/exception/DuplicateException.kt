package com.sparta.commerce_system.exception

import com.sparta.commerce_system.web.response.ApiResponseCode


class DuplicateException(override var message: String): BaseException() {
    override var code: ApiResponseCode = ApiResponseCode.DUPLICATE_ENTITY
}