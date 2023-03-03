package com.joblogic.todoapp.core.data.model

import com.joblogic.todoapp.core.model.Call
import com.joblogic.todoapp.core.network.model.NetworkCall

/**
 * Created by TC on 03/03/2023.
 */

fun NetworkCall.toCall() =
    Call(
        id = id,
        name = name,
        number = number
    )