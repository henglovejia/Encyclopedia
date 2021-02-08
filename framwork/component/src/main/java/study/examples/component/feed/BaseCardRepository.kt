package study.examples.component.feed

import android.view.ViewGroup

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */
abstract class BaseCardRepository<VH : BaseCardVH<T>, T : BaseCardItem> {
    val cardItems = mutableListOf<T>()
    abstract fun realCreate(parent: ViewGroup, viewType: Int): VH
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return realCreate(parent, viewType)
    }

    fun addCard(card: T) {
        cardItems.add(card)
    }

    fun addCards(cards: MutableList<T>) {
        cardItems.addAll(cards)
    }
}