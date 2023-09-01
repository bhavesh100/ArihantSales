package com.arihantsales.app.domain.usecase

import com.arihantsales.app.common.Resource
import com.arihantsales.app.data.remote.firebase.repository.ProductRepository
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.io.IOException
import javax.inject.Inject

class GetBannerImageUseCase @Inject constructor(val repository: ProductRepository) {
    operator fun invoke(): Flow<Resource<List<String>>> = flow {
        try {
            emit(Resource.Loading())
            val bannerImagesSnapshot = repository.getBannerImages().await()
            val images = bannerImagesSnapshot.map {
                it["image"] as String
            }
            emit(Resource.Success(images))

        } catch (e: FirebaseFirestoreException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connect"))
        }
    }
}