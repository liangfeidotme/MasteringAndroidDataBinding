package me.liangfei.databinding.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import me.liangfei.databinding.fragments.ActorProfileFragment
import me.liangfei.databinding.fragments.ActorWorksFragment


class ActorDetailPagerAdapter(fm: FragmentManager, val actorId: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int) = when (position) {
        0 -> ActorProfileFragment.newInstance(actorId)
        1 -> ActorWorksFragment()
        else -> throw IllegalStateException("no way")
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = when (position) {
        0 -> "Profile"
        1 -> "Works"
        else -> throw IllegalStateException("no way")
    }
}