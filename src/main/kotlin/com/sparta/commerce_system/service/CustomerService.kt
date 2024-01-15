package com.sparta.commerce_system.service

import com.sparta.commerce_system.domain.entity.Order
import com.sparta.commerce_system.exception.NotFoundException
import com.sparta.commerce_system.repository.OrderRepository
import com.sparta.commerce_system.repository.ProductRepository
import com.sparta.commerce_system.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerService(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
    private val orderRepository: OrderRepository
) {
    @Transactional
    fun orderCreate(userId: Long, productName: String) {
        val product = productRepository.findByProductName(productName)
        val customer = userRepository.findById(userId).orElseThrow{NotFoundException("존재하지 않는 회원입니다.")}

        val order = Order(customer, product)
        orderRepository.save(order)

        product.updateCnt(product.remainCnt - 1)
    }

    
}