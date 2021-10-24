package study.examples.basic.manager

import android.content.res.AssetManager
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.util.TypeUtils
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import study.examples.basic.feed.mapViewType2Enum
import study.examples.basic.model.BasicIndexResponse
import study.examples.basic.service.BasicApiService
import study.examples.component.log.LogImp
import study.examples.component.log.logD
import study.examples.network.NetworkManager
import java.io.BufferedReader
import java.io.InputStreamReader

class BasicApiManager : LogImp {
    private val apiService by lazy {
        NetworkManager.createService(BasicApiService::class.java)
    }

    fun getIndex(subscriber: Subscriber<BasicIndexResponse>, assetManager: AssetManager?) {
        apiService.index()
            .subscribeOn(Schedulers.io())
            .map {
                BasicIndexResponse().parseItems(it?.toString())
            }
            .doOnError {
                Observable.just(BasicIndexResponse()).map {
                    val stringBuilder = StringBuilder()
                    BufferedReader(InputStreamReader(assetManager?.open("basic.json"))).forEachLine {
                        stringBuilder.append(it)
                    }
                    BasicIndexResponse().parseItems(stringBuilder.toString())
                }.subscribe(subscriber)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
    }

    private fun BasicIndexResponse.parseItems(json: String?) = apply {
        json ?: return@apply
        val rawString = JSONObject.parseObject(json)
        code = rawString.getString("code")
        message = rawString.getString("message")
        val cardsJson = rawString.getJSONObject("data").getJSONArray("cards")
        val cardCounts = cardsJson.size
        repeat(cardCounts) { cardIndex ->
            val cardJson = cardsJson.getJSONObject(cardIndex)
            val cardType = cardJson.getString("card_type")
            val viewType = cardType.hashCode()
            val cardEnum = viewType.mapViewType2Enum()
            if (cardEnum == null) {
                "the card type of $cardType is not found".logD(this@BasicApiManager)
            } else {
                cards.add(TypeUtils.castToJavaBean(cardJson, cardEnum.cardItem).apply {
                    this.viewType = viewType
                })
            }
        }
    }

    override fun getTAG() = "BasicApiManager"
}