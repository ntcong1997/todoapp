package com.joblogic.todoapp.core.domain.usecase

import com.joblogic.todoapp.core.common.network.Dispatcher
import com.joblogic.todoapp.core.common.network.ToDoAppDispatchers
import com.joblogic.todoapp.core.data.repository.CallRepository
import com.joblogic.todoapp.core.domain.CoroutineUseCase
import com.joblogic.todoapp.core.model.Call
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by TC on 03/03/2023.
 */

class GetCallsUseCase @Inject constructor(
    private val callRepository: CallRepository,
    @Dispatcher(ToDoAppDispatchers.IO) dispatcher: CoroutineDispatcher
) : CoroutineUseCase<Unit, List<Call>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<Call> {
        return callRepository.getCalls()
    }
}