package com.arihantsales.app.data.remote.firebase.repository

import com.arihantsales.app.common.Resource
import com.arihantsales.app.data.remote.firebase.realtimedb.RealtimeModelResponse
import kotlinx.coroutines.flow.Flow

interface RealtimeRepository {
    fun getProducts(): Flow<Resource<List<RealtimeModelResponse>>>
}