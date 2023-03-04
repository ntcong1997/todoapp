package com.joblogic.todoapp.core.data.model

import com.joblogic.todoapp.core.database.model.SellEntity
import com.joblogic.todoapp.core.model.Sell
import com.joblogic.todoapp.core.network.model.NetworkItem

/**
 * Created by TC on 03/03/2023.
 */

fun NetworkItem.toSellEntity() =
    SellEntity(
        sellId = id,
        name = name,
        price = price,
        quantity = quantity
    )

fun SellEntity.toSell() = Sell(
    id = sellId,
    name = name,
    price = price,
    quantity = quantity
)