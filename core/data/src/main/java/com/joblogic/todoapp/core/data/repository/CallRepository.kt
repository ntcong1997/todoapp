package com.joblogic.todoapp.core.data.repository

import com.joblogic.todoapp.core.model.Call

/**
 * Created by TC on 03/03/2023.
 */

interface CallRepository {
    suspend fun getCalls(): List<Call>
}