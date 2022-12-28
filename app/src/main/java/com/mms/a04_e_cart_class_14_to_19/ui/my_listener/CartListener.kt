package com.mms.a04_e_cart_class_14_to_19.ui.my_listener

import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart

interface CartListener {

    fun cartAdd(cart: ProductCart)
    fun cartMinus(cart: ProductCart)
    fun cartDelete(cart: ProductCart)
}