package study.examples.component.fragment

/**
 * @author zhangHeng
 * @since 2021/1/18 5:30 下午
 * @email 932805400@qq.com
 */
abstract class BaseListFragment : BaseLogFragment() {
    /**
     * 获取RecycleView ID
     */
    abstract fun getRVId()

    /**
     * 加载态
     */
    abstract fun onLoading()

    /**
     * 加载成功
     */
    abstract fun onSuccess()

    /**
     * 加载失败
     */
    abstract fun onError()

    /**
     * 加载空数据
     */
    abstract fun onEmpty()

    /**
     * 加载更多
     */
    abstract fun loadMore()
}