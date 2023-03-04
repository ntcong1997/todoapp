package com.joblogic.todoapp.sync.work.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.joblogic.todoapp.core.common.network.Dispatcher
import com.joblogic.todoapp.core.common.network.ToDoAppDispatchers
import com.joblogic.todoapp.core.data.Synchronizer
import com.joblogic.todoapp.core.data.repository.SellRepository
import com.joblogic.todoapp.sync.work.initializers.SyncConstraints
import com.joblogic.todoapp.sync.work.initializers.syncForegroundInfo
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by TC on 04/03/2023.
 */

@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val sellRepository: SellRepository,
    @Dispatcher(ToDoAppDispatchers.IO) private val dispatcher: CoroutineDispatcher
) : CoroutineWorker(context, workerParameters), Synchronizer {
    override suspend fun getForegroundInfo(): ForegroundInfo =
        context.syncForegroundInfo()

    override suspend fun doWork(): Result = withContext(dispatcher) {
        val syncedSuccessfully = sellRepository.sync()

        if (syncedSuccessfully) {
            Result.success()
        } else {
            Result.retry()
        }
    }

    companion object {
        /**
         * Expedited one time work to sync data on app startup
         */
        fun startUpSyncWork() = OneTimeWorkRequestBuilder<DelegatingWorker>()
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .setConstraints(SyncConstraints)
            .setInputData(SyncWorker::class.delegatedData())
            .build()
    }
}