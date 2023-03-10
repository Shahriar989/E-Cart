package com.mms.a04_e_cart_class_14_to_19.utils

import com.mms.a04_e_cart_class_14_to_19.entity.Category

class Common {

    companion object {

        val getCategory: List<Category> = mutableListOf(
            Category(
                "electronics",
                "https://fakestoreapi.com/img/81QpkIctqPL._AC_SX679_.jpg"
            ),
            Category(
                "jewelery",
                "https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg"
            ),
            Category(
                "men's clothing",
                "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg"
            ),
            Category(
                "women's clothing",
                "https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg"
            )
        )
    }
}