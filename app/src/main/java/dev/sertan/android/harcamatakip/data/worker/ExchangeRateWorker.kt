package dev.sertan.android.harcamatakip.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dev.sertan.android.harcamatakip.data.repository.ExchangeRateRepository
import java.util.concurrent.TimeUnit

@HiltWorker
class ExchangeRateWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val repo: ExchangeRateRepository
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result =
        if (repo.updateExchangeRates()) Result.success() else Result.retry()

    companion object {
        private const val NAME = "ExchangeRateWorker"
        private const val REPEAT_INTERVAL = 20L
        private const val BACKOFF_DELAY = 5L

        fun setup(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val workRequest =
                PeriodicWorkRequestBuilder<ExchangeRateWorker>(REPEAT_INTERVAL, TimeUnit.MINUTES)
                    .setBackoffCriteria(BackoffPolicy.LINEAR, BACKOFF_DELAY, TimeUnit.MINUTES)
                    .setConstraints(constraints)
                    .build()

            WorkManager
                .getInstance(context)
                .enqueueUniquePeriodicWork(NAME, ExistingPeriodicWorkPolicy.KEEP, workRequest)
        }
    }
}
