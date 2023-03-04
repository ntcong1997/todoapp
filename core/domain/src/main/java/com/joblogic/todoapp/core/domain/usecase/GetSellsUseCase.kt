package com.joblogic.todoapp.core.domain.usecase

import com.joblogic.todoapp.core.data.repository.SellRepository
import com.joblogic.todoapp.core.model.Sell
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by TC on 04/03/2023.
 */

class GetSellsUseCase @Inject constructor(
    private val sellRepository: SellRepository
) {
    operator fun invoke(): Flow<List<Sell>> {
        return sellRepository.getSells()
    }
}