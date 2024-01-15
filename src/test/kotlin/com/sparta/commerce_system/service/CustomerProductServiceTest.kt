package com.sparta.commerce_system.service

import com.sparta.commerce_system.domain.entity.CategoryName
import com.sparta.commerce_system.domain.entity.Product
import com.sparta.commerce_system.domain.entity.Store
import com.sparta.commerce_system.domain.entity.User
import com.sparta.commerce_system.domain.entity.role.UserRole
import org.junit.jupiter.api.Test

class CustomerProductServiceTest {
    @Test
    fun 고객_상품_구매시_상품개수_감소() {
        val store = Store(1, 12345)
        val product = Product(CategoryName.food, "chicken", 8000, "갓 튀긴 치킨", 8, store)
        val customer = User("이동규", "1234", UserRole.customer, 1)



    }
}