package com.pemmob.h1d024040.network

import com.pemmob.h1d024040.data.model.Category
import com.pemmob.h1d024040.data.model.Product
import retrofit2.http.GET

interface ApiInterface {
    @GET("data/categories.json")
    suspend fun getCategories(): List<Category>

    @GET("data/products.json")
    suspend fun getProducts(): List<Product>
}