package study.examples.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val RXJAVA_ENGINE = 1
const val COROUTINE_ENGINE = 2

const val DEFAULT_TIME_OUT = 30L

const val BASE_URL = "http://127.0.0.1"

object NetworkManager {
    private val rxJavaRetrofit: Retrofit by lazy {
        val builder = OkHttpClient.Builder().apply {
            connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS) //连接超时时间
            writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS) //写操作 超时时间
            readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS) //读操作超时时间
        }
        Retrofit.Builder()
            .client(builder.build())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun <T> createService(service: Class<T>, engine: Int = RXJAVA_ENGINE): T {
        return rxJavaRetrofit.create(service)
    }
}