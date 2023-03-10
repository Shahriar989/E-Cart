package com.mms.a04_e_cart_class_14_to_19.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mms.a04_e_cart_class_14_to_19.R
import com.mms.a04_e_cart_class_14_to_19.entity.Category
import com.mms.a04_e_cart_class_14_to_19.ui.my_listener.CtgListener
import com.mms.a04_e_cart_class_14_to_19.viewholders.CategoryViewHolder

class CategoryAdapter(
    private val listener: CtgListener,
    private val categories: List<Category>,
    private val context: Context
) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_ctg, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val ctg: Category = categories[position]

        holder.ctgName.text = ctg.name

        Glide.with(context)
            .load(ctg.imageUrl)
            .into(holder.ctgImage)

        holder.itemView.setOnClickListener {

            listener.ctgClickListener(ctg)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}