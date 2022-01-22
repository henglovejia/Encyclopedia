package study.examples.network.coroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T : Any?> Call<T>.getResponse(): T? {
    return suspendCancellableCoroutine {
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (it.isActive) {
                    it.resume(response.body())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                it.resumeWithException(t)
            }
        })

    }
}

suspend fun <T> Call<T>.getResult(): Resource<T?> {
    return try {
        val data = getResponse()
        if (isCanceled) {
            return Resource.error(CancellationException("request was cancelled"))
        }
        Resource.success(data)
    } catch (t: Throwable) {
        Resource.error(t)
    }
}