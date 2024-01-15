package com.sparta.commerce_system.service

import com.sparta.commerce_system.domain.entity.CategoryName
import com.sparta.commerce_system.domain.entity.Product
import com.sparta.commerce_system.domain.entity.Store
import org.junit.jupiter.api.Test

class AdminProductServiceTest {
    @Test
    fun 판매자_본인_상품_조회() {
        val store = Store(1, 12345)
        val product = Product(
            CategoryName.food,
            "chicken",
            8000,
            "갓 튀긴 치킨",
            8,
            store
            )


    }
}