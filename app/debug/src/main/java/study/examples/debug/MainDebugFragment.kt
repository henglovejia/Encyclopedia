package study.examples.debug

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.examples.feed.fragment.BaseListFragmentV2
import study.examples.constant.debug.DEBUG_PAGE
import study.examples.constant.debug.DEBUG_PAGE_V1
import study.examples.debug.feed.DebugCardAdapter
import study.examples.debug.feed.DebugCardRepository
import study.examples.debug.feed.item.BaseDebugItem
import study.examples.debug.feed.item.DebugCardV1Item

/**
 * @author zhangHeng
 * @since 2021/1/20 4:37 下午
 * @email 932805400@qq.com
 * @actions 调试主页面
 */
@Route(path = DEBUG_PAGE)
class MainDebugFragment : BaseListFragmentV2() {
    private val mAdapter = DebugCardAdapter(this, DebugCardRepository())
    override fun getRVId() = R.id.recycle_view
    override fun tryPullUp() {
    }

    override fun tryPullDown() {
    }

    override fun getLayoutId() = R.layout.feed_empty_recycleview

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter.addCards(getCardList())
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    private fun getCardList(): MutableList<BaseDebugItem> {
        return mutableListOf(DebugCardV1Item("测试1", DEBUG_PAGE_V1))
    }
}