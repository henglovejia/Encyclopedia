package study.examples.component.activity

import android.view.View

abstract class BaseVBActivity : BaseLogActivity() {
    override fun getLayoutId() = View.NO_ID
}