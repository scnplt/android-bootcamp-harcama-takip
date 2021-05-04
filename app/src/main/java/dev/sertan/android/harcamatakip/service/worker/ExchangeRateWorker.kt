package dev.sertan.android.harcamatakip.service.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.*
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dev.sertan.android.harcamatakip.service.repository.ExchangeRateRepository
import java.util.concurrent.TimeUnit

@HiltWorker
class ExchangeRateWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val repo: ExchangeRateRepository
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result =
        if (repo.updateExchangeRates()) Result.success()
        else Result.failure()

    companion object {
        fun setup(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val worker = PeriodicWorkRequestBuilder<ExchangeRateWorker>(20, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

            val workManager = WorkManager.getInstance(context)

            workManager.enqueue(worker)
        }
    }
}