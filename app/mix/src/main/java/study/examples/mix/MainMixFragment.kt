package study.examples.mix

import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.component.fragment.BaseLogFragment
import study.examples.constant.MIX_MAIN_PAGE

/**
 * @author zhangHeng
 * @since 2021/1/20 5:42 下午
 * @email 932805400@qq.com
 * @actions 混合开发主页面
 */
@Route(path = MIX_MAIN_PAGE)
class MainMixFragment : BaseLogFragment() {
    override fun getLayoutId() = R.layout.activity_mix_main
}