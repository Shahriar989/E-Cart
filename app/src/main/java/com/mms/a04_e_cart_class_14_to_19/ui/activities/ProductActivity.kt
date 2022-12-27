package com.mms.a04_e_cart_class_14_to_19.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.mms.a04_e_cart_class_14_to_19.R
import com.mms.a04_e_cart_class_14_to_19.data.online.retrofit.MyRetrofit.Companion.getRetrofit
import com.mms.a04_e_cart_class_14_to_19.databinding.ActivityProductBinding
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart
import com.mms.a04_e_cart_class_14_to_19.entity.ProductsItem
import com.mms.a04_e_cart_class_14_to_19.ui.adapter.ProductAdapter
import com.mms.a04_e_cart_class_14_to_19.ui.my_listener.CartAddListener
import com.mms.a04_e_cart_class_14_to_19.viewmodels.CartViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductActivity : AppCompatActivity(), CartAddListener {

    lateinit var binding: ActivityProductBinding

    private var ctgName: String? = null
    lateinit var productsItem: List<ProductsItem>

    lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ctgName = intent.getStringExtra("name")

        viewModel = ViewModelProvider(this)[CartViewModel::class.java]

        val ctgNameToolbar = findViewById<TextView>(R.id.categoryName)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        ctgNameToolbar.text = ctgName
        setSupportActionBar(toolbar)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        productsItem = ArrayList<ProductsItem>()
        getAllProductFromServer(ctgName!!)
    }

    private fun getAllProductFromServer(ctg: String) {
        val getItems: Call<List<ProductsItem>> = getRetrofit().getAllProductsByCtg(ctg)

        getItems.enqueue(object : Callback<List<ProductsItem>> {
            override fun onResponse(
                call: Call<List<ProductsItem>>,
                response: Response<List<ProductsItem>>
            ) {
                productsItem = response.body()!!

                setupRecyclerView()
            }

            override fun onFailure(call: Call<List<ProductsItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun setupRecyclerView() {
        val adapter: ProductAdapter = ProductAdapter(productsItem, baseContext, this)
        binding.productRecycler.adapter = adapter
        binding.productRecycler.setHasFixedSize(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun cartAdd(cart: ProductCart) {
        viewModel.insertCart(cart)
        Toast.makeText(this, "Cart Added", Toast.LENGTH_LONG).show()
    }
}