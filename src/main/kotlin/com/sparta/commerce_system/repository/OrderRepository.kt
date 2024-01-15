package com.sparta.commerce_system.repository

import com.sparta.commerce_system.domain.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository:JpaRepository<Order, Long> {
}