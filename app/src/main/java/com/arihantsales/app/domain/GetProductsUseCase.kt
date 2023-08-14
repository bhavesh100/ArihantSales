package com.arihantsales.app.domain

import com.arihantsales.app.common.Resource
import com.arihantsales.app.domain.model.Product
import com.arihantsales.app.domain.repository.ProductRepository
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val productsSnapshot = repository.getproducts().await()
            val products = productsSnapshot.documents.map { data->
                Product(
                    id = data["id"] as String,
                    name = data["name"] as String,
                    thumbnail = data["thumbnail"] as String,
                    description = data["description"] as String
                )
            }
            emit(Resource.Success(products))

        } catch (e: FirebaseFirestoreException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connect"))
        }
    }
}