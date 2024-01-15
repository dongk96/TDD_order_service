package com.sparta.commerce_system.repository

import com.sparta.commerce_system.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<User, Long> {
}