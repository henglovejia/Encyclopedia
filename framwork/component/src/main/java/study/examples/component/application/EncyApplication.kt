package study.examples.component.application

import android.app.Application
import android.content.Context

/**
 * @author Alpha
 * @since 2/9/21
 * @email zhangheng@bilibili.com
 * @description
 */
class EncyApplication : BaseApplication() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        val application = when (base) {
            is Application -> {
                base
            }
            else -> this
        }
        EncyContext.bindApplication(application)
    }
}