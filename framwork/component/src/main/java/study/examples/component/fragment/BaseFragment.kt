package study.examples.component.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author zhangHeng
 * @since 2021/1/18 3:18 下午
 * @email 932805400@qq.com
 * @actions 1、ARouter路由注册 2、布局文件获取
 */
abstract class BaseFragment : BaseLogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beforeCreateView()
        return inflater.inflate(getLayoutId(), container, false).apply {
            afterCreateView(this)
        }
    }

    open fun beforeCreateView() {}
    abstract fun getLayoutId(): Int
    open fun afterCreateView(view: View) {}
}