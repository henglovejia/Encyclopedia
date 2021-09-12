package study.examples.component.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author zhangHeng
 * @since 2021/1/18 3:18 下午
 * @email 932805400@qq.com
 * @actions 1、ARouter路由注册 2、布局文件获取
 */
abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
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
    abstract fun afterCreateView(view: View)
}