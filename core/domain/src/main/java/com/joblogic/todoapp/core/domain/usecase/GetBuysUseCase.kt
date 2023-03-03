package com.joblogic.todoapp.core.domain.usecase

import com.joblogic.todoapp.core.common.network.Dispatcher
import com.joblogic.todoapp.core.common.network.ToDoAppDispatchers
import com.joblogic.todoapp.core.data.repository.BuyRepository
import com.joblogic.todoapp.core.domain.CoroutineUseCase
import com.joblogic.todoapp.core.model.Buy
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by TC on 03/03/2023.
 */

class GetBuysUseCase @Inject constructor(
    private val buyRepository: BuyRepository,
    @Dispatcher(ToDoAppDispatchers.IO) dispatcher: CoroutineDispatcher
) : CoroutineUseCase<Unit, List<Buy>>(dispatcher) {
    override suspend fun execute(parameters: Unit): List<Buy> {
        return buyRepository.getBuys()
    }
}