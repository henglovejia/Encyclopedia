package study.examples.component.feed

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import study.examples.component.fragment.BaseFragment

/**
 * @author Alpha
 * @since 2/7/21
 * @email zhangheng@bilibili.com
 * @description
 */
abstract class BaseCardAdapter<VH : BaseCardVH<BaseCardItem>>(
    private val fragment: BaseFragment,
    private val cardRepository: BaseCardRepository<VH, BaseCardItem>
) : RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int {
        return cardRepository.cardItems.size
    }

    override fun getItemViewType(position: Int): Int {
        return cardRepository.cardItems.getOrNull(position)?.viewType ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return cardRepository.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        cardRepository.cardItems.getOrNull(position)?.run {
            holder.bindData(fragment, this)
            holder.realBind()
        }
    }

    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        holder.onRecycled()
    }
}