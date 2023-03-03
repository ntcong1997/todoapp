package com.joblogic.todoapp.core.data.model

import com.joblogic.todoapp.core.model.Sell
import com.joblogic.todoapp.core.network.model.NetworkBuySell

/**
 * Created by TC on 03/03/2023.
 */

fun NetworkBuySell.toSell() =
    Sell(
        id = id,
        name = name,
        price = price,
        quantity = quantity
    )