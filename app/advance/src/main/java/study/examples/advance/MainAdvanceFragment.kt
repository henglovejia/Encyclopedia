package study.examples.advance

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.advance.feed.AdvanceCardAdapter
import study.examples.advance.feed.AdvanceCardRepository
import study.examples.advance.feed.item.AdvanceCardV1Item
import com.examples.feed.fragment.BaseListFragmentV2
import study.examples.constant.advance.ADVANCE_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:06 下午
 * @email 932805400@qq.com
 * @actions 进阶知识主页面
 */
@Route(path = ADVANCE_PAGE)
class MainAdvanceFragment : com.examples.feed.fragment.BaseListFragmentV2() {
    private val mAdapter = AdvanceCardAdapter(this, AdvanceCardRepository())
    override fun getRVId() = R.id.recycle_view
    override fun getLayoutId() = R.layout.activity_advance_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter.addCard(AdvanceCardV1Item())
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }
}