package com.mms.a04_e_cart_class_14_to_19.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mms.a04_e_cart_class_14_to_19.databinding.ItemCartBinding
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart
import com.mms.a04_e_cart_class_14_to_19.ui.my_listener.CartListener
import com.mms.a04_e_cart_class_14_to_19.viewholders.CartViewHolder

class CartAdapter(
    val context: Context,
    val productList: List<ProductCart>,
    val cartListener: CartListener
) : RecyclerView.Adapter<CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        //val view= LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        val binding = ItemCartBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart: ProductCart = productList[position]
        holder.binding.cartItemName.text = cart.title
        holder.binding.cartItemPrice.text = cart.price.toString()
        holder.binding.cartItemQuantity.text = cart.quantity.toString()

        Glide.with(context)
            .load(cart.image)
            .into(holder.binding.cartItemImage)
        holder.binding.cartItemPlus.setOnClickListener {

            cartListener.cartAdd(cart)
        }
        holder.binding.cartItemMinus.setOnClickListener {

            cartListener.cartMinus(cart)
        }
        holder.binding.cartItemDelete.setOnClickListener {

            cartListener.cartDelete(cart)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}