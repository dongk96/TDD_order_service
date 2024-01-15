package com.sparta.commerce_system.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "store")
class Store(adminId: Long, licenseNum: Long) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val storeId: Long? = null

    @Column(name = "admin")
    var adminId: Long = adminId

    @Column(name = "license")
    var licenseNum: Long = licenseNum

    @OneToMany(mappedBy = "store")
    var products: MutableList<Product> = mutableListOf()

    fun addStore(product: Product) {
        this.products.add(product)
    }
}