package study.examples.component.feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import study.examples.component.fragment.BaseFragment

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */
abstract class BaseCardVH<T : BaseCardItem>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private var fragment: BaseFragment? = null
    private lateinit var data: T
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