package com.joblogic.todoapp.core.network.model
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


/**
 * Created by TC on 03/03/2023.
 */

@Serializable
data class NetworkCall(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("number")
    val number: String?
)