package com.mms.a04_e_cart_class_14_to_19.data.ofline.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mms.a04_e_cart_class_14_to_19.data.ofline.daos.CartDao
import com.mms.a04_e_cart_class_14_to_19.entity.ProductCart

@Database(
    entities = [ProductCart::class],
    version = 1
)
abstract class CartDatabase : RoomDatabase() {

    abstract fun getCartDAo(): CartDao

    companion object {

        fun getDatabase(context: Context): CartDatabase {

            var instance: CartDatabase? = null
            return if (instance == null) {

                instance = Room.databaseBuilder(
                    context,
                    CartDatabase::class.java,
                    "Cart_DB"
                ).build()
                instance
            } else {
                return instance
            }
        }
    }
}