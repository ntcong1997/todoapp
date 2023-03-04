package com.joblogic.todoapp.core.data.model

import com.joblogic.todoapp.core.model.Buy
import com.joblogic.todoapp.core.network.model.NetworkItem

/**
 * Created by TC on 03/03/2023.
 */

fun NetworkItem.toBuy() =
    Buy(
        id = id,
        name = name,
        price = price,
        quantity = quantity
    )