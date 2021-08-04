package study.examples.mix

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.examples.feed.fragment.BaseListFragmentV2
import study.examples.constant.MIX_PAGE
import study.examples.mix.feed.MixCardAdapter
import study.examples.mix.feed.MixCardRepository
import study.examples.mix.feed.item.MixCardV1Item

/**
 * @author zhangHeng
 * @since 2021/1/20 5:42 下午
 * @email 932805400@qq.com
 * @actions 混合开发主页面
 */
@Route(path = MIX_PAGE)
class MainMixFragment : BaseListFragmentV2() {
    private val mAdapter = MixCardAdapter(this, MixCardRepository())
    override fun getRVId() = R.id.recycle_view
    override fun tryPullUp() {
    }

    override fun tryPullDown() {
    }

    override fun getLayoutId() = R.layout.activity_mix_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter.addCard(MixCardV1Item())
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }
}