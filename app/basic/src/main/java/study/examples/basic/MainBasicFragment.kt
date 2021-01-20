package study.examples.basic

import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.component.fragment.BaseLogFragment
import study.examples.constant.BASIC_MAIN_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:34 下午
 * @email 932805400@qq.com
 * @actions 基础知识主页面
 */
@Route(path = BASIC_MAIN_PAGE)
class MainBasicFragment : BaseLogFragment() {
    override fun getLayoutId() = R.layout.activity_basic_main
}