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
import study.examples.basic.model.card.BaseBasicItem
import study.examples.constant.basic.BASIC_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:34 下午
 * @email 932805400@qq.com
 * @actions 基础知识主页面
 */
@Route(path = BASIC_PAGE)
class MainBasicFragment : BaseListFragmentV1() {
    private val mFeedData = mutableListOf<BaseBasicItem>()
    private val mAdapter = BasicCardAdapter(this, BasicCardRepository(), mFeedData)
    override fun getRVId() = R.id.recycle_view

    override fun tryPullUp() {
        load(false)
    }

    override fun tryPullDown() {
        load()
    }

    override fun onLoading() {
    }

    override fun onSuccess() {
    }

    override fun onError() {
    }

    private fun load(isPullDown: Boolean = true) {
        BasicApiManager.getIndex(object : Subscriber<BasicIndexResponse>() {
            override fun onCompleted() {
            }

            override fun onError(e: Throwable?) {
            }

            override fun onNext(response: BasicIndexResponse) {
                var startIndex = mFeedData.size
                if (isPullDown) {
                    mFeedData.clear()
                    startIndex = 0
                }
                response.cards.let {
                    mAdapter.addCards(it)
                }
                mAdapter.notifyItemInserted(startIndex)
            }
        })
    }

    override fun getLayoutId() = R.layout.activity_basic_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.adapter = mAdapter
        load()
    }
}