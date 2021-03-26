package study.examples.component.application

import android.app.Application
import android.content.Context

/**
 * @author ZhangHeng
 * @since 2/9/21
 * @email 932805400@qq.com
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