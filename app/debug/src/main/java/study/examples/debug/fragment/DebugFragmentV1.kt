package study.examples.debug.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.examples.feed.fragment.BaseListFragmentV2
import study.examples.constant.debug.DEBUG_PAGE_V1
import study.examples.debug.R

/**
 * @author Alpha
 * @since 3/23/21
 * @email zhangheng@bilibili.com
 * @description
 */
@Route(path = DEBUG_PAGE_V1)
class DebugFragmentV1 : com.examples.feed.fragment.BaseListFragmentV2() {
    override fun getRVId() = R.id.recycle_view

    override fun getLayoutId() = R.layout.fragment_debug_v1
}