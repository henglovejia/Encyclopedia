package com.examples.feed.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examples.feed.item.BaseCardItem
import com.examples.feed.repository.BaseCardRepository
import com.examples.feed.holder.BaseCardVH
import study.examples.component.fragment.BaseFragment
import study.examples.component.log.LogImp
import study.examples.component.log.logD

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
abstract class BaseCardAdapter<VH : BaseCardVH<T>, T : BaseCardItem>(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<VH, T>
) : RecyclerView.Adapter<VH>(), LogImp {
    override fun getTAG(): String = javaClass.simpleName

    override fun getItemCount(): Int {
        logD("card item count:${cardRepository.cardItems.size}")
        return cardRepository.cardItems.size
    }

    override fun getItemViewType(position: Int): Int {
        logD("card item view type:${cardRepository.cardItems.getOrNull(position)?.viewType ?: 0}")
        return cardRepository.cardItems.getOrNull(position)?.viewType ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return cardRepository.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        cardRepository.cardItems.getOrNull(position)?.run {
            holder.bindData(fragment, this)
        }
    }

    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        holder.onRecycled()
    }

    open fun addCard(card: T) {
        cardRepository.addCard(card)
    }

    open fun addCards(cards: MutableList<T>) {
        cardRepository.addCards(cards)
    }

    open fun delCards() {
        cardRepository.delCards()
    }

    open fun getItems() = cardRepository.cardItems
}