//package com.example.bootckakao.presentation
//
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentActivity
//import androidx.viewpager2.adapter.FragmentStateAdapter
//
//class ViewPagerAdapter(fragmentActivity: FragmentActivity):
//    FragmentStateAdapter(fragmentActivity) {
//    private var fragments : ArrayList<Fragment> = ArrayList()
//
//    override fun getItemCount(): Int = fragments.size
//
//    override fun createFragment(position: Int): Fragment {
//        return fragments[position]
//    }
//
////    override fun createFragment(position: Int): Fragment {
////        return when (position) {
////            0 -> ContactListFragment()
////            else -> MyPageFragment()
////        }
////    }
//
//
//    fun addFragment(fragment: Fragment) {
//        fragments.add(fragment)
//        notifyItemInserted(fragments.size-1)
//    }
//
//    fun removeFragment() {
//        fragments.removeLast()
//        notifyItemRemoved(fragments.size)
//    }
//}