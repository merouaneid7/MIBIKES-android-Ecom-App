package com.example.idhasessionproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idhasessionproject.adapter.ProductAdapter
import com.example.idhasessionproject.db.AppDatabase
import com.example.idhasessionproject.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.productsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from Room Database asynchronously
        GlobalScope.launch(Dispatchers.Main) {
            val products = fetchProductsFromDatabase()
            productAdapter = ProductAdapter(products)
            recyclerView.adapter = productAdapter
        }
    }

    // Function to fetch products from the Room Database
    private suspend fun fetchProductsFromDatabase(): List<Product> {
        val db = AppDatabase.getDatabase(applicationContext)
        return db.productDao().getAllProducts()
    }
}