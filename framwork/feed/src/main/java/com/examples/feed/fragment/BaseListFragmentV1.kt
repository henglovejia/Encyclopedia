package com.examples.feed.fragment

/**
 * @author zhangHeng
 * @since 2021/1/18 5:30 下午
 * @email 932805400@qq.com
 * @description 请求网络的列表页
 */
abstract class BaseListFragmentV1 : BaseListFragment() {
    override fun tryPullUp() {}
    override fun onLoading() {}
    override fun onSuccess() {}
    override fun onError() {}
    override fun onEmpty() {}
}