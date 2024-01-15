package com.sparta.commerce_system.domain.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener


@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener::class)
class Order(user: User, product: Product) {
    init {
        user.addOrder(this)
        product.addOrder(this)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "user-id")
    var user: User = user

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "store_id")
    var product: Product = product

    @Column(name = "status-now")
    var statusNow: String = "결제대기"

    fun updateStatus(status: String) {
        this.statusNow = status
    }
}