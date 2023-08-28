package com.arihantsales.app.domain.repository

import com.arihantsales.app.common.Resource
import com.arihantsales.app.domain.model.Product
import com.google.android.gms.common.api.Response
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot

interface ProductRepository {
    suspend fun getproducts(): Task<QuerySnapshot>
    suspend fun getBannerImages(): Task<QuerySnapshot>
}