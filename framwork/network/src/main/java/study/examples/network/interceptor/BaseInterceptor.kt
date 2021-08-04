package study.examples.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

abstract class BaseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest: Request = chain.request()
        val requestBuilder = oldRequest.newBuilder()
        requestBuilder.method(oldRequest.method, oldRequest.body)
        addHeader()?.forEach { (key, value) ->
            requestBuilder.header(key, value)
        }
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }

    abstract fun addHeader(): HashMap<String, String>?
}