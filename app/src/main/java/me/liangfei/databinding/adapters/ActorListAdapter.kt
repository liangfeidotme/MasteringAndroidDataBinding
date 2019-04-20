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
import me.liangfei.databinding.data.entities.Actor
import me.liangfei.databinding.databinding.ListItemActorBinding
import me.liangfei.databinding.databinding.ListItemAddBinding
import me.liangfei.databinding.fragments.ActorCollectionFragmentDirections


class ActorListAdapter : ListAdapter<Actor, RecyclerView.ViewHolder>(ActorDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            if (viewType.isTypeAdd()) {
                AddViewHolder(
                        DataBindingUtil.inflate(
                                LayoutInflater.from(parent.context),
                                R.layout.list_item_add, parent, false
                        )
                )
            } else {
                ViewHolder(
                        DataBindingUtil.inflate(
                                LayoutInflater.from(parent.context),
                                R.layout.list_item_actor, parent, false
                        )
                )
            }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position).isTypeAdd()) {
            (holder as AddViewHolder).bind(View.OnClickListener {
                // TODO go to add more actors
            })
        } else {
            getItem(position).let { actor ->
                with(holder as ViewHolder) {
                    itemView.tag = actor
                    bind(createOnClickListener(actor.actorId), actor)
                }
            }
        }
    }

    private fun createOnClickListener(actorId: Int): View.OnClickListener {
        return View.OnClickListener {
            val direction = ActorCollectionFragmentDirections.showActorDetail(actorId)
            it.findNavController().navigate(direction)
        }
    }

    override fun getItemViewType(position: Int) =
            if (position == itemCount - 1) VIEW_TYPE_ADD else VIEW_TYPE_ACTOR


    override fun getItemCount() = super.getItemCount() + 1

    class ViewHolder(
            private val binding: ListItemActorBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, actor: Actor) {
            with(binding) {
                clickListener = listener
                this.actor = actor
                executePendingBindings()
            }
        }
    }

    class AddViewHolder(val binding: ListItemAddBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener) {
            binding.onClickListener = listener
        }
    }

    companion object {
        private const val VIEW_TYPE_ACTOR = 0x00
        private const val VIEW_TYPE_ADD = 0x01

        fun Int.isTypeAdd() = this == VIEW_TYPE_ADD
    }
}

private class ActorDiffCallback : DiffUtil.ItemCallback<Actor>() {
    override fun areContentsTheSame(oldItem: Actor, newItem: Actor) =
            oldItem.name == newItem.name

    override fun areItemsTheSame(oldItem: Actor, newItem: Actor) =
            oldItem.actorId == newItem.actorId

}

