package study.examples.advance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.examples.feed.databinding.FeedEmptyRecycleviewBinding
import study.examples.advance.feed.AdvanceCardAdapter
import study.examples.advance.feed.card.BaseAdvanceCard
import study.examples.advance.model.item.AdvanceCardV1Item
import study.examples.advance.model.item.BaseAdvanceItem
import study.examples.component.ext.viewBinding
import study.examples.component.fragment.BaseLogFragment
import study.examples.constant.advance.ADVANCE_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:06 下午
 * @email 932805400@qq.com
 * @actions 进阶知识主页面
 */
@Route(path = ADVANCE_PAGE)
class MainAdvanceFragment : BaseLogFragment() {
    private val mBinding by viewBinding<FeedEmptyRecycleviewBinding>()
    private lateinit var mAdapter: AdvanceCardAdapter<BaseAdvanceCard<BaseAdvanceItem>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = AdvanceCardAdapter(
            this, arrayListOf(
                AdvanceCardV1Item("测试卡片", ""),
            )
        )
        mBinding.recycleView.layoutManager = LinearLayoutManager(this.context)
        mBinding.recycleView.adapter = mAdapter
    }
}