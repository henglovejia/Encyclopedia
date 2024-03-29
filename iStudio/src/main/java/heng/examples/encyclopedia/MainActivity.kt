package heng.examples.encyclopedia

import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView
import heng.examples.encyclopedia.adapter.NavigationAdapter
import study.examples.component.activity.BaseLogActivity
import study.examples.component.log.logE
import study.examples.constant.main.MAIN_PAGE

@Route(path = MAIN_PAGE)
class MainActivity : BaseLogActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    ViewPager.OnPageChangeListener {
    private lateinit var mBottomNavigation: BottomNavigationView
    private lateinit var mMainPage: ViewPager
    private val mFragments by lazy {
        resources.getStringArray(R.array.navigation_fragments)
    }
    private val mItemIds = arrayOf(
        R.id.navigation_debug,
        R.id.navigation_basic,
        R.id.navigation_advance,
        R.id.navigation_mix
    )

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBottomNavigation = findViewById(R.id.bottom_navigation)
        mMainPage = findViewById(R.id.main_pager)
        addNavigationMenus()
    }

    private fun addNavigationMenus() {
        val navigationTitleSize = mBottomNavigation.menu.size()
        if (navigationTitleSize != mFragments.size) {
            logE(
                "init navigation menu failure because the number of " +
                    "title:${navigationTitleSize} and fragment:${mFragments.size} " +
                    "is not match"
            )
            return
        }
        mBottomNavigation.setOnNavigationItemSelectedListener(this)
        mMainPage.adapter = NavigationAdapter(mFragments, supportFragmentManager)
        mMainPage.addOnPageChangeListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_debug -> {
                mMainPage.setCurrentItem(0, true)
            }
            R.id.navigation_basic -> {
                mMainPage.setCurrentItem(1, true)
            }
            R.id.navigation_advance -> {
                mMainPage.setCurrentItem(2, true)
            }
            R.id.navigation_mix -> {
                mMainPage.setCurrentItem(3, true)
            }
            else -> {
                return false
            }
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainPage.removeOnPageChangeListener(this)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        mItemIds.getOrNull(position)?.let { mBottomNavigation.selectedItemId = it }
    }

    override fun onPageScrollStateChanged(state: Int) {
    }
}