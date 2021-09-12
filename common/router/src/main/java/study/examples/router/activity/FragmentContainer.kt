package study.examples.router.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.activity.BaseActivity
import study.examples.constant.common.CONTAINER_PAGE
import study.examples.constant.common.KEY_FRAGMENT_CONTAINER
import study.examples.router.R

@Route(path = CONTAINER_PAGE)
class FragmentContainer : BaseActivity() {
    override fun getLayoutId() = R.layout.router_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.getString(KEY_FRAGMENT_CONTAINER)?.let { uri ->
            (ARouter.getInstance().build(uri).navigation() as? Fragment)?.let { fragment ->
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_content, fragment)
                fragmentTransaction.commitAllowingStateLoss()
            }
        }
    }
}