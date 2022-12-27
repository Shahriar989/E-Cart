package com.mms.a04_e_cart_class_14_to_19.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.mms.a04_e_cart_class_14_to_19.R

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
    val favoriteImageView: AppCompatButton = itemView.findViewById(R.id.favoriteImageView)
    val addToCartButton: AppCompatButton = itemView.findViewById(R.id.addToCartButton)
    val productTitleTextView: AppCompatTextView = itemView.findViewById(R.id.productTitleTextView)
    val productCategoryTextView: AppCompatTextView =
        itemView.findViewById(R.id.productCategoryTextView)
    val productPriceTextView: AppCompatTextView = itemView.findViewById(R.id.productPriceTextView)
}