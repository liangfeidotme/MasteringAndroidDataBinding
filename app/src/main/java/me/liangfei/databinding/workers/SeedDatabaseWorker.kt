package me.liangfei.databinding.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import me.liangfei.databinding.data.Actor
import me.liangfei.databinding.data.AppDatabase
import me.liangfei.databinding.utilities.ACTOR_DATA_FILENAME


class SeedDatabaseWorker(
        context: Context,
        workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }
    override val coroutineContext = Dispatchers.IO

    override suspend fun doWork(): Result = coroutineScope {

        try {
            applicationContext.assets.open(ACTOR_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val actorType = object : TypeToken<List<Actor>>() {}.type
                    val actorList: List<Actor> = Gson().fromJson(jsonReader, actorType)

                    val database = AppDatabase.getInstance(applicationContext)
                    database.actorDao().insertAll(actorList)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }
}