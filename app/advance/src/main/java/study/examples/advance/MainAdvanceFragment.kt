package study.examples.advance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.advance.feed.AdvanceCardAdapter
import com.examples.feed.fragment.BasePaging3Fragment
import kotlinx.coroutines.launch
import study.examples.advance.databinding.ActivityAdvanceMainBinding
import study.examples.advance.lifecycle.AdvanceViewModel
import study.examples.component.ext.viewBinding
import study.examples.constant.advance.ADVANCE_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:06 下午
 * @email 932805400@qq.com
 * @actions 进阶知识主页面
 */
@Route(path = ADVANCE_PAGE)
class MainAdvanceFragment : BasePaging3Fragment<AdvanceCardAdapter>() {
    private val mViewModel by viewModels<AdvanceViewModel>()
    private val mBinding by viewBinding<ActivityAdvanceMainBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = AdvanceCardAdapter(this)
        mBinding.recycleView.adapter = mAdapter
        lifecycleScope.launch {
//            mViewModel.loadStateFlow.collectLatest { pagingData ->
//                pagingAdapter.submitData(pagingData)
//            }
        }
    }
}