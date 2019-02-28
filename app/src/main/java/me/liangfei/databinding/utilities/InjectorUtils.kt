package me.liangfei.databinding.utilities

import android.content.Context
import me.liangfei.databinding.data.ActorRepository
import me.liangfei.databinding.data.AppDatabase
import me.liangfei.databinding.viewmodels.ActorViewModelFactory


object InjectorUtils {
    private fun getActorRepository(context: Context): ActorRepository {
        return ActorRepository.getInstance(
                AppDatabase.getInstance(context.applicationContext).actorDao())
    }

    fun provideActorViewModelFactory(
            context: Context
    ): ActorViewModelFactory {
        val repository = getActorRepository(context)
        return ActorViewModelFactory(repository)
    }
}
