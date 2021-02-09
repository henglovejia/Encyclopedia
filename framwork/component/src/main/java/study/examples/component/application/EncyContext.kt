package study.examples.component.application

import android.app.Application

/**
 * @author Alpha
 * @since 2/9/21
 * @email zhangheng@bilibili.com
 * @description
 */
object EncyContext {
    var application: Application? = null

    @JvmStatic
    fun bindApplication(app: Application) {
        application = app
    }
}