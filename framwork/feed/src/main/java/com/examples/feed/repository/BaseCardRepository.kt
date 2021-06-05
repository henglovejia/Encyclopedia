package com.examples.feed.repository

import android.view.ViewGroup
import com.examples.feed.holder.BaseCardVH
import com.examples.feed.item.BaseCardItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
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