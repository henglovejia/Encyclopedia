package com.examples.feed.fragment

/**
 * @author zhangHeng
 * @since 1/29/21
 * @email 932805400@qq.com
 * @description 请求本地的列表页
 */
abstract class BaseListFragmentV2 : BaseListFragment() {
    override fun onLoading() {}

    override fun onSuccess() {}

    override fun onError() {}
}