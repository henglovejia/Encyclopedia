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
    fun Activity.routerTo(uri: String?, requestCode: Int = 0) {
        uri ?: return
        ARouter.getInstance().build(uri).navigation(this, requestCode, object : NavigationCallback {
            override fun onFound(postcard: Postcard?) {
                logD("onFound")
                postcard?.run {
                    if (type == RouteType.FRAGMENT) {
                        ARouter.getInstance().build(CONTAINER_PAGE).with(Bundle().apply {
                            putString(KEY_FRAGMENT_CONTAINER, uri)
                        }).navigation()
                    }
                }
            }

            override fun onLost(postcard: Postcard?) {
                logD("onLost")
            }

            override fun onArrival(postcard: Postcard?) {
                logD("onArrival")
            }

            override fun onInterrupt(postcard: Postcard?) {
                logD("onInterrupt")
            }
        })
    }

    override fun getTAG() = "RouterManager"
}