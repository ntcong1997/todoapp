package com.joblogic.todoapp.core.domain.usecase

import com.joblogic.todoapp.core.common.network.Dispatcher
import com.joblogic.todoapp.core.common.network.ToDoAppDispatchers
import com.joblogic.todoapp.core.data.repository.SellRepository
import com.joblogic.todoapp.core.domain.CoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by TC on 04/03/2023.
 */

class SyncSellsUseCase @Inject constructor(
    private val sellRepository: SellRepository,
    @Dispatcher(ToDoAppDispatchers.IO) dispatcher: CoroutineDispatcher
) : CoroutineUseCase<Unit, Unit>(dispatcher) {
    override suspend fun execute(parameters: Unit) {
        sellRepository.syncSells()
    }
}