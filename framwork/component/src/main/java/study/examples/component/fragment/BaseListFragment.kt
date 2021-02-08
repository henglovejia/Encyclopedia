package study.examples.component.fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Alpha
 * @since 1/29/21
 * @email zhangheng@bilibili.com
 * @description
 */
abstract class BaseListFragment : BaseLogFragment() {
    lateinit var mRecyclerView: RecyclerView

    override fun afterCreateView(view: View) {
        super.afterCreateView(view)
        mRecyclerView = view.findViewById(getRVId())
    }

    /**
     * 获取RecycleView ID
     */
    abstract fun getRVId(): Int



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
    fun onEmpty() {}

    /**
     * 加载更多
     */
    fun loadMore() {}
}