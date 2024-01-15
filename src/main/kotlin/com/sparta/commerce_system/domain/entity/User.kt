package com.sparta.commerce_system.domain.entity

import com.sparta.commerce_system.domain.entity.role.UserRole
import com.sparta.commerce_system.exception.BadRequestException
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    username: String,
    password: String,
    role: UserRole,
    storeId: Long?,
    wallet: Long
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null

    @Column(name = "username", unique = true)
    var username: String = username

    @Column(name = "password")
    var password: String = password

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    var role: UserRole = role

    @Column(name = "storeId")
    var storeId: Long? = null

    @Column(name = "wallet")
    var wallet: Long = wallet

    @OneToMany(mappedBy = "user")
    var orders: MutableList<Order> = mutableListOf()

    fun addOrder(order: Order) {
        this.orders.add(order)
    }

    fun chargeWallet(point: Long) {
        this.wallet = point
    }

    fun buyProducts() {
        var totalPay: Long = 0
        for(i in this.orders) {
            totalPay += i.product.price
        }

        if(this.wallet < totalPay) {
            throw BadRequestException("포인트가 부족합니다.")
        }

        this.wallet -= totalPay
    }
}