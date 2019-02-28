package me.liangfei.databinding.data


class ActorRepository private constructor(private val actorDao: ActorDao) {
    fun getActors() = actorDao.getActors()

    fun getActor(actorId: String) = actorDao.getActor(actorId)

    companion object {
        @Volatile private var instance: ActorRepository? = null

        fun getInstance(actorDao: ActorDao) =
                instance ?: synchronized(this) {
                    instance ?: ActorRepository(actorDao).also { instance = it}
                }
    }
}
