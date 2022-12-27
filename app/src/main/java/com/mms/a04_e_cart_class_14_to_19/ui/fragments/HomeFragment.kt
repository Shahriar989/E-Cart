package com.mms.a04_e_cart_class_14_to_19.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mms.a04_e_cart_class_14_to_19.databinding.FragmentHomeBinding
import com.mms.a04_e_cart_class_14_to_19.entity.Category
import com.mms.a04_e_cart_class_14_to_19.entity.SliderItem
import com.mms.a04_e_cart_class_14_to_19.ui.activities.ProductActivity
import com.mms.a04_e_cart_class_14_to_19.ui.adapter.CategoryAdapter
import com.mms.a04_e_cart_class_14_to_19.ui.adapter.SliderAdapter
import com.mms.a04_e_cart_class_14_to_19.ui.my_listener.CtgListener
import com.mms.a04_e_cart_class_14_to_19.utils.Common

class HomeFragment : Fragment(), CtgListener {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter: CategoryAdapter = CategoryAdapter(this, Common.getCategory, requireActivity())
        binding.ctgRecyclerView.adapter = adapter
        binding.ctgRecyclerView.setHasFixedSize(true)

        setupSlider()

        return view
    }

    private fun setupSlider() {
        val sliderList = listOf<SliderItem>(
            SliderItem(
                "Image 1",
                "https://i.pinimg.com/originals/88/e1/f9/88e1f93024ce28f5e66f279ddeb0c6ce.png"
            ),
            SliderItem(
                "Image 2",
                "https://i.pinimg.com/originals/c7/28/58/c72858992482c70d5ec3a585eec352ed.png"
            ),
            SliderItem(
                "Image 3",
                "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/7bad8c93546277.5f48a570f12f8.jpg"
            ),
            SliderItem(
                "Image 4",
                "https://slidebazaar.com/wp-content/uploads/2021/09/super-sale-product-template.jpg"
            )
        )
        val adapter: SliderAdapter = SliderAdapter(requireActivity(), sliderList)
            binding.banner.setSliderAdapter(adapter)
    }

    override fun ctgClickListener(category: Category) {
        val intent: Intent = Intent(requireActivity(), ProductActivity::class.java)
        intent.putExtra("name", category.name)
        startActivity(intent)
    }
}