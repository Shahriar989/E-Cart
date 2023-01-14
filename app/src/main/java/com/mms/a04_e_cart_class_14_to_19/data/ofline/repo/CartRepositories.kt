package com.mms.a04_e_cart_class_14_to_19.data.ofline.repo

import com.mms.a04_e_cart_class_14_to_19.data.ofline.db.CartDatabase
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart

class CartRepositories( val db: CartDatabase) {

    suspend fun insertCart(cart: ProductCart) = db.getCartDAo().insert(cart)
    suspend fun updateCart(cart: ProductCart) = db.getCartDAo().update(cart)
    suspend fun deleteCart(cart: ProductCart) = db.getCartDAo().delete(cart)

    fun getAllCart() = db.getCartDAo().getAllCart()
}