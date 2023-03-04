package com.joblogic.todoapp.core.network.model
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


/**
 * Created by TC on 03/03/2023.
 */

@Serializable
data class NetworkBuySell(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("price")
    val price: Long?,
    @SerialName("quantity")
    val quantity: Int?,
    @SerialName("type")
    val type: Int?
) {
    val buySellType: BuySellType
        get() = when (type) {
            1 -> BuySellType.BUY
            2 -> BuySellType.SELL
            else -> BuySellType.UNKNOWN
        }
}

enum class BuySellType {
    BUY,
    SELL,
    UNKNOWN
}