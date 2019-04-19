package me.liangfei.databinding.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import me.liangfei.databinding.data.entities.Actor
import me.liangfei.databinding.data.entities.Work

@Entity(
        foreignKeys = [
            ForeignKey(
                    entity = Actor::class,
                    parentColumns = ["id"],
                    childColumns = ["actor_id"]
            ),
            ForeignKey(
                    entity = Work::class,
                    parentColumns = ["id"],
                    childColumns = ["work_id"]
            )
        ],
        primaryKeys = ["work_id", "actor_id"],
        tableName = "actor_work_bindings"
)
data class ActorWork(
        @ColumnInfo(name = "work_id")
        val workId: Int,
        @ColumnInfo(name = "actor_id")
        val actorId: Int
)
