package study.examples.advance.network

import study.examples.network.COROUTINE_ENGINE
import study.examples.network.NetworkManager

class AdvanceApiManager {
    private val apiService by lazy {
        NetworkManager.createService(AdvanceApiService::class.java, COROUTINE_ENGINE)
    }
}