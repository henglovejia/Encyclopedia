package study.examples.router

import android.app.Activity
import android.os.Bundle
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback
import com.alibaba.android.arouter.facade.enums.RouteType
import com.alibaba.android.arouter.launcher.ARouter
import study.examples.component.log.LogImp
import study.examples.component.log.logD
import study.examples.constant.common.CONTAINER_PAGE
import study.examples.constant.common.KEY_FRAGMENT_CONTAINER

object RouterManager : LogImp {
    fun routerTo(uri: String?, context: Activity? = null, requestCode: Int = 0) {
        uri ?: return
        ARouter.getInstance().build(uri).navigation(context, requestCode, object : NavigationCallback {
            override fun onFound(postcard: Postcard?) {
                "onFound".logD(this@RouterManager)
                postcard?.run {
                    if (type == RouteType.FRAGMENT) {
                        ARouter.getInstance().build(CONTAINER_PAGE).with(Bundle().apply {
                            putString(KEY_FRAGMENT_CONTAINER, uri)
                        }).navigation()
                    }
                }
            }

            override fun onLost(postcard: Postcard?) {
                "onLost".logD(this@RouterManager)
            }

            override fun onArrival(postcard: Postcard?) {
                "onArrival".logD(this@RouterManager)
            }

            override fun onInterrupt(postcard: Postcard?) {
                "onInterrupt".logD(this@RouterManager)
            }
        })
    }

    override fun getTAG() = "RouterManager"
}