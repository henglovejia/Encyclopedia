package study.examples.advance.feed

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import com.examples.paging3.adapter.BasePagingDataAdapter
import kotlinx.coroutines.Dispatchers
import study.examples.advance.feed.card.AdvanceCardV1
import study.examples.advance.feed.card.BaseAdvanceCard
import study.examples.advance.model.item.BaseAdvanceItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class AdvanceCardAdapter(private val fragment: Fragment) :
    BasePagingDataAdapter<BaseAdvanceItem, BaseAdvanceCard<BaseAdvanceItem>>(CardComparator, Dispatchers.Main, Dispatchers.IO) {
    override fun onBindViewHolder(holder: BaseAdvanceCard<BaseAdvanceItem>, position: Int) {
        getItem(position)?.let { holder.bindData(fragment, it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseAdvanceCard<BaseAdvanceItem> {
        return when (viewType) {
            AdvanceCardType.ADVANCE_CARD_V1.viewType -> AdvanceCardV1.createView(parent)
            else -> AdvanceCardV1.createView(parent)
        } as BaseAdvanceCard<BaseAdvanceItem>
    }

    object CardComparator : DiffUtil.ItemCallback<BaseAdvanceItem>() {
        override fun areItemsTheSame(oldItem: BaseAdvanceItem, newItem: BaseAdvanceItem): Boolean {
            return oldItem.viewType == newItem.viewType
        }

        override fun areContentsTheSame(oldItem: BaseAdvanceItem, newItem: BaseAdvanceItem): Boolean {
            return oldItem.title == newItem.title && oldItem.uri == newItem.uri
        }
    }
}