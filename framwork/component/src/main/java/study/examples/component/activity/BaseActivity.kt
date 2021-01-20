package study.examples.component.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author zhangHeng
 * @since 2021/1/18 3:18 下午
 * @email 932805400@qq.com
 * @actions 1、ARouter路由注册 2、布局文件获取
 */
abstract class BaseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()?.let { setContentView(it) }
        ARouter.getInstance().inject(this)
    }

    open fun getLayoutId(): Int? = null
}