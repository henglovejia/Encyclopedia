package study.examples.basic.manager

import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.parser.ParserConfig
import com.alibaba.fastjson.util.TypeUtils
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import study.examples.basic.feed.mapViewType2Enum
import study.examples.basic.model.BasicIndexResponse
import study.examples.basic.service.BasicApiService
import study.examples.component.log.LogImp
import study.examples.component.log.logD
import study.examples.network.NetworkManager


object BasicApiManager : LogImp {
    fun getIndex(subscriber: Subscriber<BasicIndexResponse>) {
        NetworkManager.createService(BasicApiService::class.java).index()
            .subscribeOn(Schedulers.io())
            .map {
                BasicIndexResponse().apply {
                    it ?: return@apply
                    val rawString = JSONObject.parseObject(it.string())
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
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
    }

    override fun getTAG() = "BasicApiManager"
}