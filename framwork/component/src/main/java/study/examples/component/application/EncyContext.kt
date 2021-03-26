package study.examples.component.application

import android.app.Application

/**
 * @author ZhangHeng
 * @since 2/9/21
 * @email 932805400@qq.com
 * @description
 */
object EncyContext {
    var application: Application? = null

    @JvmStatic
    fun bindApplication(app: Application) {
        application = app
    }
}