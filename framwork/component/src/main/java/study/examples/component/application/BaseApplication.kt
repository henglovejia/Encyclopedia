package study.examples.component.application

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.drawee.backends.pipeline.Fresco
import study.examples.component.BuildConfig

/**
 * @author zhangheng
 * @since 2021/1/18 3:38 下午
 * @email 932805400@qq.com
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        Fresco.initialize(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}