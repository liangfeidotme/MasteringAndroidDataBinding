package me.liangfei.databinding.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.liangfei.databinding.R
import me.liangfei.databinding.data.Actor
import me.liangfei.databinding.databinding.ListItemActorBinding
import me.liangfei.databinding.fragments.ActorListFragmentDirections


class ActorListAdapter : ListAdapter<Actor, ActorListAdapter.ViewHolder>(ActorDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.list_item_actor, parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { actor ->
            with(holder) {
                itemView.tag = actor
                bind(createOnClickListener(actor.actorId), actor)
            }
        }
    }

    private fun createOnClickListener(actorId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = ActorListFragmentDirections.showActorDetail(actorId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
            private val binding: ListItemActorBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, actor: Actor) {
            with (binding) {
                clickListener = listener
                actorName = actor.name
                executePendingBindings()
            }
        }
    }
}

private class ActorDiffCallback : DiffUtil.ItemCallback<Actor>() {
    override fun areContentsTheSame(oldItem: Actor, newItem: Actor) =
            oldItem.name == newItem.name

    override fun areItemsTheSame(oldItem: Actor, newItem: Actor) =
            oldItem.actorId == newItem.actorId

}

