package com.examples.feed.holder

import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.examples.feed.item.BaseCardItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
abstract class BaseCardVH<T : BaseCardItem>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected var fragment: Fragment? = null
    protected lateinit var data: T
    protected abstract fun bindView()
    private var viewType: Int = 0
    fun onRecycled() {
        fragment = null
    }

    fun bindData(fragment: Fragment, data: T) {
        this.fragment = fragment
        this.data = data
        viewType = data.viewType
        bindView()
    }
}