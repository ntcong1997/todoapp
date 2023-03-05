package com.joblogic.todoapp.core.testing.data

import com.joblogic.todoapp.core.model.Sell

/**
 * Created by TC on 05/03/2023.
 */

val sellsTestData: List<Sell> = listOf(
    Sell(
        id = 1,
        name = "Macbook",
        price = 200000,
        quantity = 1
    ),
    Sell(
        id = 2,
        name = "iPhone",
        price = 50000,
        quantity = 2
    ),
    Sell(
        id = 3,
        name = "Samsung",
        price = 40000,
        quantity = 3
    )
)