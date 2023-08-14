package com.arihantsales.app.data.remote.firebase.realtimedb

import com.arihantsales.app.domain.model.Product

data class RealtimeModelResponse(
    val item: Product?,
    val key: String? = ""
) {
}