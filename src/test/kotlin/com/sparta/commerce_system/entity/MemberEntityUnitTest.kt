package com.sparta.commerce_system.entity

import com.sparta.commerce_system.domain.entity.*
import com.sparta.commerce_system.domain.entity.role.UserRole
import com.sparta.commerce_system.exception.BadRequestException
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MemberEntityUnitTest {
    @Test
    fun 고객_잔여_포인트_차감() {
        val customer = User("이동규", "1234", UserRole.customer,null, 100000)
        val store = Store(1, 12345)
        val product1 = Product(CategoryName.food, "chicken", 5000, "갓 튀긴 치킨", 5, store)
        val product2 = Product(CategoryName.drink, "cola", 2000, "콜라", 10, store)
        val order1 = Order(customer, product1)
        val order2 = Order(customer, product2)

        customer.orders.add(order1)
        customer.orders.add(order2)

        customer.buyProducts()
        assertTrue(customer.wallet == 93000L)
    }

    @Test
    fun 고객_포인트_부족() {
        val customer = User("이동규", "1234", UserRole.customer,null, 1000)
        val store = Store(1, 12345)
        val product1 = Product(CategoryName.food, "chicken", 5000, "갓 튀긴 치킨", 5, store)
        val product2 = Product(CategoryName.drink, "cola", 2000, "콜라", 10, store)
        val order1 = Order(customer, product1)
        val order2 = Order(customer, product2)

        customer.orders.add(order1)
        customer.orders.add(order2)

        assertThrows<BadRequestException>(message = "포인트 부족") {
            customer.buyProducts()
        }
    }
}