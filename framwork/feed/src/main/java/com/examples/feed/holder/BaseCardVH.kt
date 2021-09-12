package com.examples.feed.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.examples.feed.item.BaseCardItem
import study.examples.component.fragment.BaseFragment

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
abstract class BaseCardVH<T : BaseCardItem>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected var fragment: BaseFragment? = null
    lateinit var data: T
    private var viewType: Int = 0
    abstract fun realBind()
    fun onRecycled() {
        fragment = null
    }

    fun bindData(fragment: BaseFragment, data: T) {
        this.fragment = fragment
        this.data = data
        viewType = data.viewType
    }
}