package com.mms.a04_e_cart_class_14_to_19.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mms.a04_e_cart_class_14_to_19.data.ofline.db.CartDatabase
import com.mms.a04_e_cart_class_14_to_19.data.ofline.repo.CartRepositories
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application)
    :
    AndroidViewModel(application){

        private val repo: CartRepositories

        init {
            val db = CartDatabase.getDatabase(application.applicationContext)
            repo = CartRepositories(db)
        }
    fun insertCart(cart: ProductCart) = CoroutineScope(Dispatchers.IO)
        .launch {
        repo.insertCart(cart)
    }
    fun updateCart(cart: ProductCart) = CoroutineScope(Dispatchers.IO)
        .launch {
        repo.updateCart(cart)
    }
    fun deleteCart(cart: ProductCart) = CoroutineScope(Dispatchers.IO)
        .launch {
        repo.deleteCart(cart)
    }

    fun getAllCart() = repo.getAllCart()
}