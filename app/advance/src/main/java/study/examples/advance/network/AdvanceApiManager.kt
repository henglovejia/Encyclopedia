package study.examples.advance.network

import android.content.res.AssetManager
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.util.TypeUtils
import study.examples.advance.feed.mapViewType2Enum
import study.examples.advance.model.AdvanceIndexResponse
import study.examples.component.log.LogImp
import study.examples.component.log.logD
import study.examples.network.COROUTINE_ENGINE
import study.examples.network.NetworkManager
import study.examples.network.coroutine.getResponse
import java.io.BufferedReader
import java.io.InputStreamReader

class AdvanceApiManager : LogImp {
    private val apiService by lazy {
        NetworkManager.createService(AdvanceApiService::class.java, COROUTINE_ENGINE)
    }

    suspend fun getIndex(assetManager: AssetManager?): AdvanceIndexResponse {
        val response = apiService.index().getResponse()
        return AdvanceIndexResponse().parseItems(response.toString(), assetManager)
    }

    private fun AdvanceIndexResponse.parseItems(json: String?, assetManager: AssetManager?) = apply {
        var parseJson = json
        if (json.isNullOrBlank()) {
            val stringBuilder = StringBuilder()
            BufferedReader(InputStreamReader(assetManager?.open("basic.json"))).forEachLine {
                stringBuilder.append(it)
            }
            parseJson = stringBuilder.toString()
        }
        val rawString = JSONObject.parseObject(parseJson)
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
                logD("the card type of $cardType is not found")
            } else {
                cards.add(TypeUtils.castToJavaBean(cardJson, cardEnum.cardItem).apply {
                    this.viewType = viewType
                })
            }
        }
    }

    override fun getTAG() = "AdvanceApiManager"
}