package com.mms.a04_e_cart_class_14_to_19.data.ofline.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart

@Dao
interface CartDao {

    @Insert
    suspend fun insert(cart: ProductCart)

    @Update
    suspend fun update(cart: ProductCart)

    @Delete
    suspend fun delete(cart: ProductCart)

    @Query("SELECT * FROM cart_items")
    fun getAllCart(): LiveData<List<ProductCart>>
}