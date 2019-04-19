package me.liangfei.databinding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_actor_detail.*
import me.liangfei.databinding.adapters.ActorDetailPagerAdapter
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

        // init view pager
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.adapter = ActorDetailPagerAdapter(requireFragmentManager())

        binding.imageUrl = "http://img.mp.itc.cn/upload/20161210/7a14ce89d0e44a8591f0ec7bac09ccb5_th.jpg"

        // TODO ViewPager 加上 tab，一个显示详情，一个展示影视作品，两边都用 RecyclerView。
        return binding.root
    }
}