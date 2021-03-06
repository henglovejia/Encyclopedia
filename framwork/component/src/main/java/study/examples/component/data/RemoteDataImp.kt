package study.examples.network.repository


/**
 * @author zhangHeng
 * @since 2021/1/20 5:22 下午
 * @email 932805400@qq.com
 * @actions 1、数据类操作接口:增，删，改，查
 */
interface DataAsyncImp {
    /**
     * 增
     */
    fun <T, R> add(data: T?, callback: DataCallback<R>?) {}

    /**
     * 删
     */
    fun <T, R> delete(data: T?, callback: DataCallback<R>?) {}

    /**
     * 改
     */
    fun <T, R> update(data: T?, callback: DataCallback<R>?) {}

    /**
     * 查
     */
    fun <T, R> query(data: T?, callback: DataCallback<R>?) {}
}

interface DataSyncImp {
    /**
     * 增
     */
    fun <T> add(data: T?): Boolean

    /**
     * 删
     */
    fun <T> delete(data: T?): Boolean

    /**
     * 改
     */
    fun <T> update(data: T?): Boolean

    /**
     * 查
     */
    fun <T, R> query(data: T?): R
}

interface DataCallback<R> {
    fun onSuccess(t: R?)
    fun onFailure(errorMsg: String?)
}