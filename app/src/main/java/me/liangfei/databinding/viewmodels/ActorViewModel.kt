package me.liangfei.databinding.viewmodels

import androidx.lifecycle.ViewModel
import me.liangfei.databinding.data.ActorRepository

/**
 * Created by LIANG.FEI on 25/1/2019.
 */
class ActorViewModel internal constructor(private val actorRepository: ActorRepository)
    : ViewModel() {
    val actors = actorRepository.getActors()
    fun actorDetail(actorId: String) = actorRepository.getActor(actorId)
}