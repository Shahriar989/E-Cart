package com.mms.a04_e_cart_class_14_to_19.data.online.dao

import com.mms.a04_e_cart_class_14_to_19.entity.ProductsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDao {

    @GET("/products")
    fun getAllProducts(): Call<List<ProductsItem>>

    @GET("/products/category/{ctg}")
    fun getAllProductsByCtg(@Path("ctg") id: String): Call<List<ProductsItem>>

    //https://fakestoreapi.com/products/category/jewelery
}