package me.liangfei.databinding.viewmodels

import androidx.databinding.BaseObservable
import me.liangfei.databinding.data.ActorRepository

/**
 * Created by LIANG.FEI on 25/1/2019.
 */
class ActorViewModel internal constructor(actorRepository: ActorRepository)
    : BaseObservable() {
    val actors = actorRepository.getActors()
}