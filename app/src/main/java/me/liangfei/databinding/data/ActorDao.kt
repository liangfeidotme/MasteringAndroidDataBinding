package me.liangfei.databinding.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.liangfei.databinding.data.entities.Actor


@Dao
interface ActorDao {
    @Query("SELECT id, name, avatar FROM actors")
    fun getActors(): LiveData<List<Actor>>

    @Query("SELECT * FROM actors WHERE id = :actorId")
    fun getActor(actorId: Int): LiveData<Actor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(actors: List<Actor>)
}