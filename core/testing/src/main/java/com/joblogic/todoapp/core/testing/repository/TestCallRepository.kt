package com.joblogic.todoapp.core.testing.repository

import com.joblogic.todoapp.core.data.repository.CallRepository
import com.joblogic.todoapp.core.model.Call
import com.joblogic.todoapp.core.testing.data.callsTestData

/**
 * Created by TC on 05/03/2023.
 */

class TestCallRepository : CallRepository {
    override suspend fun getCalls(): List<Call> {
        return callsTestData
    }
}