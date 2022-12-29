package com.mms.a04_e_cart_class_14_to_19.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mms.a04_e_cart_class_14_to_19.databinding.FragmentCartBinding
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart
import com.mms.a04_e_cart_class_14_to_19.ui.adapter.CartAdapter
import com.mms.a04_e_cart_class_14_to_19.ui.my_listener.CartListener
import com.mms.a04_e_cart_class_14_to_19.viewmodels.CartViewModel

class CartFragment : Fragment(), CartListener {

    lateinit var binding: FragmentCartBinding

    lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        cartViewModel= ViewModelProvider(this)[CartViewModel::class.java]
        cartViewModel.getAllCart().observe(viewLifecycleOwner){

            val adapter = CartAdapter(requireActivity(), it, this)
            binding.cartRecyclerView.adapter= adapter
            binding.cartRecyclerView.setHasFixedSize(true)

            binding.amountToPay.text= "Amount to pay: ${getTotalAmount(it)}"
        }
        return binding.root
    }

    private fun getTotalAmount(it: List<ProductCart>?): Double {

        var mAmount: Double = 0.0

        it!!.forEach {
            mAmount += (it.price*it.quantity)
        }
        return mAmount
    }

    override fun cartAdd(cart: ProductCart) {
        var qty= cart.quantity+1
        val mCart: ProductCart = ProductCart(
            cart.title,
            cart.description,
            cart.id,
            cart.image,
            cart.price,
            cart.title,
            qty
        )
        cartViewModel.updateCart(mCart)
    }

    override fun cartMinus(cart: ProductCart) {
        var qty = cart.quantity - 1
        val mCart: ProductCart = ProductCart(
            cart.title,
            cart.description,
            cart.id,
            cart.image,
            cart.price,
            cart.title,
            qty
        )
        if (qty >= 1) {

            cartViewModel.updateCart(mCart)
        }else{
            Toast.makeText(requireActivity(), "Quantity can't be less than 1",Toast.LENGTH_LONG).show()
            showAlert("Are you Sure?","Do you want to delete this cart?", cart)
        }
    }

    override fun cartDelete(cart: ProductCart) {

        showAlert("Are you Sure?","Do you want to delete this cart?", cart)
    }

    fun showAlert(title:String, msg: String, cart: ProductCart){

        val builder: AlertDialog.Builder =AlertDialog.Builder(requireActivity())
        builder.setTitle(title)
        builder.setMessage(msg)
        builder.setCancelable(true)

        builder.setPositiveButton("Yes"){dialog, which->

            cartViewModel.deleteCart(cart)
        }

        builder.setNegativeButton("No"){dialog, which->

        }

        val alertDialog:AlertDialog = builder.create()
        alertDialog.show()
    }
}