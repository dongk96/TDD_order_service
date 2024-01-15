package com.sparta.commerce_system.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "product")
class Product (
    category: CategoryName,
    productName: String,
    price: Long,
    description: String,
    remainCnt: Long,
    store: Store
) {

    init {
        store.addStore(this)
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long? = null

    @Column(name = "category")
    var category: CategoryName = category

    @Column(name = "product-name")
    var productName: String = productName

    @Column(name = "price")
    var price: Long = price

    @Column(name = "description")
    var description: String = description

    @Column(name = "remain-count")
    var remainCnt: Long = remainCnt

    @OneToMany(mappedBy = "product")
    var orders: MutableList<Order> = mutableListOf()

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "store-id")
    var store: Store = store

    fun addOrder(order: Order) {
        this.orders.add(order)
    }

    fun updateCnt(updateRemainCnt: Long) {
        this.remainCnt = updateRemainCnt
    }
}