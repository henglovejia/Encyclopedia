package study.examples.component.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.component.log.LogImp
import study.examples.component.log.logD

abstract class BaseVBFragment : BaseLogFragment(), LogImp {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        logD("Fragment onCreateView")
        return null
    }

    override fun getLayoutId() = View.NO_ID

    override fun afterCreateView(view: View) {}
}