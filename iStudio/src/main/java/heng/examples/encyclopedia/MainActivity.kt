package heng.examples.encyclopedia

import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.component.activity.BaseActivity
import study.examples.constant.MAIN_PAGE

@Route(path = MAIN_PAGE)
class MainActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_main
}