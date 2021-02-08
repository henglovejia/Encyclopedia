package study.examples.debug

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.component.fragment.BaseListFragmentV2
import study.examples.constant.debug.DEBUG_PAGE
import study.examples.debug.feed.DebugCardAdapter
import study.examples.debug.feed.DebugCardRepository
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

    override fun getLayoutId() = R.layout.activity_debug_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter.cardRepository.addCard(DebugCardV1Item())
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }
}