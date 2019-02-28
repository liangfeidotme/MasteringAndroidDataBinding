package me.liangfei.databinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.liangfei.databinding.databinding.FragmentActorListBinding

/**
 * Created by LIANG.FEI on 25/1/2019.
 */
class ActorListFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActorListBinding.inflate(inflater, container, false)
        return binding.root
    }
}