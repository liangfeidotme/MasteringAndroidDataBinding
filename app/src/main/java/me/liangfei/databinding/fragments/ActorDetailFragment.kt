package me.liangfei.databinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import me.liangfei.databinding.databinding.FragmentActorDetailBinding

/**
 * Created by LIANG.FEI on 25/1/2019.
 */
class ActorDetailFragment : Fragment() {
    private val params by navArgs<ActorDetailFragmentArgs>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActorDetailBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        // TODO ViewPager 加上 tab，一个显示详情，一个展示影视作品，两边都用 RecyclerView。
        return binding.root
    }
}