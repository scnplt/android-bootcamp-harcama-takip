package dev.sertan.android.harcamatakip.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.*
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
        if (repo.updateExchangeRates()) Result.success()
        else Result.retry()

    companion object {
        private const val NAME = "ExchangeRateWorker"

        fun setup(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val workRequest = PeriodicWorkRequestBuilder<ExchangeRateWorker>(20, TimeUnit.MINUTES)
                .setBackoffCriteria(BackoffPolicy.LINEAR, 5, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

            WorkManager
                .getInstance(context)
                .enqueueUniquePeriodicWork(NAME, ExistingPeriodicWorkPolicy.KEEP, workRequest)
        }
    }
}