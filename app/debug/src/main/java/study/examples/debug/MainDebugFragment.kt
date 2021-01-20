package study.examples.debug

import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.component.fragment.BaseLogFragment
import study.examples.constant.DEBUG_MAIN_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 4:37 下午
 * @email 932805400@qq.com
 * @actions 调试主页面
 */
@Route(path = DEBUG_MAIN_PAGE)
class MainDebugFragment : BaseLogFragment() {
    override fun getLayoutId() = R.layout.activity_debug_main
}