package com.sparta.commerce_system.repository

import com.sparta.commerce_system.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
    fun findByProductName(productName: String): Product
}