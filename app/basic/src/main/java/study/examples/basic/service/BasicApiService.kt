package study.examples.basic.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import rx.Observable

interface BasicApiService {
    @GET("basic/index")
    fun index(): Observable<ResponseBody?>
}