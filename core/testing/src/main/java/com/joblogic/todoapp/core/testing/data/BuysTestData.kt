package com.joblogic.todoapp.core.testing.data

import com.joblogic.todoapp.core.model.Buy

/**
 * Created by TC on 05/03/2023.
 */

val buysTestData: List<Buy> = listOf(
    Buy(
        id = 1,
        name = "Macbook",
        price = 200000,
        quantity = 1
    ),
    Buy(
        id = 2,
        name = "iPhone",
        price = 50000,
        quantity = 2
    ),
    Buy(
        id = 3,
        name = "Samsung",
        price = 40000,
        quantity = 3
    )
)