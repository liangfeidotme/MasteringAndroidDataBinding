package me.liangfei.databinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import me.liangfei.databinding.adapters.ActorListAdapter
import me.liangfei.databinding.databinding.FragmentActorListBinding
import me.liangfei.databinding.utilities.InjectorUtils
import me.liangfei.databinding.viewmodels.ActorViewModel

/**
 * Created by LIANG.FEI on 25/1/2019.
 */
class ActorListFragment : Fragment() {
    private lateinit var viewModel: ActorViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActorListBinding.inflate(inflater, container, false)

        val context = context ?: return binding.root
        val factory = InjectorUtils.provideActorViewModelFactory(context)

        viewModel = ViewModelProviders.of(requireActivity(), factory)
                .get(ActorViewModel::class.java)

        binding.actorListView.layoutManager = GridLayoutManager(context, 3)

        val adapter = ActorListAdapter()
        binding.actorListView.adapter = adapter
        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: ActorListAdapter) {
        viewModel.actors.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}