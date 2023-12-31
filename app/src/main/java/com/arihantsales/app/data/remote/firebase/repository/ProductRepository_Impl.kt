package com.arihantsales.app.data.remote.firebase.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class ProductRepository_Impl @Inject constructor(
    private val db: FirebaseFirestore
): ProductRepository {
    override suspend fun getproducts(): Task<QuerySnapshot> {
        return db.collection("products").get()
    }

    override suspend fun getBannerImages(): Task<QuerySnapshot> {
        return db.collection("banner_images").get()
    }
}