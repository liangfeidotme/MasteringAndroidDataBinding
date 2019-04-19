package me.liangfei.databinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import me.liangfei.databinding.databinding.FragmentActorProfileBinding
import me.liangfei.databinding.utilities.InjectorUtils
import me.liangfei.databinding.viewmodels.ActorViewModel


class ActorProfileFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActorProfileBinding.inflate(
                inflater, container, false
        )

        val context = context ?: return binding.root
        val factory = InjectorUtils.provideActorViewModelFactory(context)
        val viewModel = ViewModelProviders.of(this, factory)
                .get(ActorViewModel::class.java)

        val actorId = arguments?.getInt(ARG_ACTOR_ID)
        actorId?.let {
            viewModel.actorDetail(actorId).observe(viewLifecycleOwner, Observer {
                binding.actor = it
            })
        }

        return binding.root
    }

    companion object {
        private const val ARG_ACTOR_ID = "arg_actor_id"

        fun newInstance(actorId: Int) = ActorProfileFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ACTOR_ID, actorId)
            }
        }
    }
}