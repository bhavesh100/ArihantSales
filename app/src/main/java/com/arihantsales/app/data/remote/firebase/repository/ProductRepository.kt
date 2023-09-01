package com.arihantsales.app.data.remote.firebase.repository


import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

interface ProductRepository {
    suspend fun getproducts(): Task<QuerySnapshot>
    suspend fun getBannerImages(): Task<QuerySnapshot>
}