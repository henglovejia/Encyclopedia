package com.examples.feed.fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import study.examples.component.fragment.BaseFragment
import study.examples.component.fragment.BaseLogFragment

/**
 * @author ZhangHeng
 * @since 1/29/21
 * @email 932805400@qq.com
 * @description
 */
abstract class BaseListFragment : BaseFragment() {
    lateinit var mRecyclerView: RecyclerView

    override fun afterCreateView(view: View) {
        mRecyclerView = view.findViewById(getRVId())
    }

    /**
     * 获取RecycleView ID
     */
    abstract fun getRVId(): Int

    /**
     * 上拉加载
     */
    abstract fun tryPullUp()

    /**
     * 下拉加载
     */
    abstract fun tryPullDown()

    /**
     * 加载中
     */
    abstract fun onLoading()

    /**
     * 加载成功
     */
    abstract fun onSuccess()

    /**
     * 加载失败
     */
    abstract fun onError()

    /**
     * 加载空数据
     */
    open fun onEmpty() {}
}