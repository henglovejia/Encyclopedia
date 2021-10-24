package study.examples.basic

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.examples.feed.fragment.BaseListFragmentV1
import rx.Subscriber
import study.examples.basic.feed.BasicCardAdapter
import study.examples.basic.feed.BasicCardRepository
import study.examples.basic.manager.BasicApiManager
import study.examples.basic.model.BasicIndexResponse
import study.examples.component.log.logE
import study.examples.constant.basic.BASIC_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:34 下午
 * @email 932805400@qq.com
 * @actions 基础知识主页面
 */
@Route(path = BASIC_PAGE)
class MainBasicFragment : BaseListFragmentV1() {
    private val mAdapter = BasicCardAdapter(this, BasicCardRepository())
    private val mApiManager = BasicApiManager()
    override fun getRVId() = R.id.recycle_view

    override fun tryPullDown() {
        load()
    }

    private fun load(isPullDown: Boolean = true) {
        mApiManager.getIndex(object : Subscriber<BasicIndexResponse>() {
            override fun onCompleted() {
            }

            override fun onError(e: Throwable?) {
                e.toString().logE(this@MainBasicFragment)
            }

            override fun onNext(response: BasicIndexResponse) {
                var startIndex = mAdapter.getItems().size
                if (isPullDown) {
                    mAdapter.delCards()
                    startIndex = 0
                }
                response.cards.let {
                    mAdapter.addCards(it)
                }
                mAdapter.notifyItemInserted(startIndex)
            }
        }, resources.assets)
    }

    override fun getLayoutId() = R.layout.activity_basic_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = mAdapter
        load()
    }
}