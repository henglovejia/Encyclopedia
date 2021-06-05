package study.examples.basic

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.basic.feed.BasicCardAdapter
import study.examples.basic.feed.BasicCardRepository
import study.examples.basic.feed.item.BasicCardV1Item
import com.examples.feed.fragment.BaseListFragmentV2
import study.examples.constant.basic.BASIC_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:34 下午
 * @email 932805400@qq.com
 * @actions 基础知识主页面
 */
@Route(path = BASIC_PAGE)
class MainBasicFragment : com.examples.feed.fragment.BaseListFragmentV2() {
    private val mAdapter = BasicCardAdapter(this, BasicCardRepository())
    override fun getRVId() = R.id.recycle_view
    override fun getLayoutId() = R.layout.activity_basic_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter.addCard(BasicCardV1Item())
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }
}