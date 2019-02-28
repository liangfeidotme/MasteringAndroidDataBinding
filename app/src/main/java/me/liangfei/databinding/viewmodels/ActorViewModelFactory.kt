package me.liangfei.databinding.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.liangfei.databinding.data.ActorRepository


@Suppress("UNCHECKED_CAST")
class ActorViewModelFactory(
        private val repository: ActorRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ActorViewModel(repository) as T
    }
}