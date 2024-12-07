package com.example.idhasessionproject.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.idhasessionproject.models.Product


@Dao
interface ProductDao {
    @Insert
    suspend fun insert(product: Product)

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<Product>
}