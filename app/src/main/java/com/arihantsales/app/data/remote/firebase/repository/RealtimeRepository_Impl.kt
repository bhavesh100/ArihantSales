package com.arihantsales.app.data.remote.firebase.repository

import com.arihantsales.app.common.Resource
import com.arihantsales.app.data.remote.firebase.realtimedb.RealtimeModelResponse
import kotlinx.coroutines.flow.Flow

class RealtimeRepository_Impl: RealtimeRepository {
    override fun getProducts(): Flow<Resource<List<RealtimeModelResponse>>> {
        TODO("Not yet implemented")
    }
}