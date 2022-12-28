package com.mms.a04_e_cart_class_14_to_19.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mms.a04_e_cart_class_14_to_19.databinding.FragmentCartBinding
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart
import com.mms.a04_e_cart_class_14_to_19.ui.adapter.CartAdapter
import com.mms.a04_e_cart_class_14_to_19.viewmodels.CartViewModel

class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding

    lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        cartViewModel= ViewModelProvider(this)[CartViewModel::class.java]
        cartViewModel.getAllCart().observe(viewLifecycleOwner){

            val adapter = CartAdapter(requireActivity(), it)
            binding.cartRecyclerView.adapter= adapter
            binding.cartRecyclerView.setHasFixedSize(true)


            binding.amountToPay.text= "Amount to pay: ${getTotalAmount(it)}"
        }
        return binding.root
    }

    private fun getTotalAmount(it: List<ProductCart>?): Double {

        var mAmount: Double = 0.0

        it!!.forEach {
            mAmount += it.price
        }
        return mAmount
    }

}