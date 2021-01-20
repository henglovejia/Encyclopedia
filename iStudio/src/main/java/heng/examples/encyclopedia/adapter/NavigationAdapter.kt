package heng.examples.encyclopedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author zhangHeng
 * @since 2021/1/20 6:05 下午
 * @email 932805400@qq.com
 * @actions
 */
class NavigationAdapter(private val mFragments: Array<String>, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount() = mFragments.size

    override fun getItem(position: Int): Fragment {
        if (mFragments.size <= position) {
            return Fragment()
        }
        return (ARouter.getInstance().build(mFragments[position]).navigation() as? Fragment)
            ?: Fragment()
    }
}