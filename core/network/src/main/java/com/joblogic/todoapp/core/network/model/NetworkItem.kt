package com.joblogic.todoapp.core.network.model
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


/**
 * Created by TC on 03/03/2023.
 */

@Serializable
data class NetworkItem(
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
    val itemType: ItemType
        get() = when (type) {
            1 -> ItemType.BUY
            2 -> ItemType.SELL
            else -> ItemType.UNKNOWN
        }
}

enum class ItemType {
    BUY,
    SELL,
    UNKNOWN
}