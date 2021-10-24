package study.examples.advance.network

import retrofit2.http.GET
import study.examples.advance.model.AdvanceIndexResponse

interface AdvanceApiService {
    @GET("advance/index")
    fun index(): AdvanceIndexResponse
}