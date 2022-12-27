package com.mms.a04_e_cart_class_14_to_19.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mms.a04_e_cart_class_14_to_19.R

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val ctgImage: ImageView= itemView.findViewById(R.id.ctg_image)
    val ctgName: TextView= itemView.findViewById(R.id.ctg_Name)
}