package com.sparta.commerce_system.entity

import com.sparta.commerce_system.domain.entity.*
import com.sparta.commerce_system.domain.entity.role.UserRole
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ProductEntityUnitTest {
    @Test
    fun 물품_개수_차감() {
        val customer = User("이동규", "1234", UserRole.customer,null, 1000)
        val store = Store(1, 12345)
        val product1 = Product(CategoryName.food, "chicken", 5000, "갓 튀긴 치킨", 5, store)
        val order1 = Order(customer, product1)

        product1.updateCnt(product1.remainCnt - 1)

        assertTrue(product1.remainCnt == 4L)
    }
}