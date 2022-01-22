package study.examples.basic.modules.views

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import study.examples.basic.R
import study.examples.component.fragment.BaseFragment
import study.examples.constant.basic.BASIC_TEXTVIEW_FRAGMENT

@Route(path = BASIC_TEXTVIEW_FRAGMENT)
class TextViewFragment : BaseFragment() {
    override fun getLayoutId() = R.layout.basic_text_view_fragment
    override fun afterCreateView(view: View) {
    }
}