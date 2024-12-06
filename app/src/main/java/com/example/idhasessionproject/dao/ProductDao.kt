package com.example.idhasessionproject.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.idhasessionproject.models.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>
}
