package study.examples.advance

import com.alibaba.android.arouter.facade.annotation.Route
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
    override fun getLayoutId() = R.layout.activity_advance_main
}