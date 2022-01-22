package study.examples.advance.feed

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import study.examples.advance.feed.card.AdvanceCardV1
import study.examples.advance.feed.card.BaseAdvanceCard
import study.examples.advance.model.item.BaseAdvanceItem

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */
class AdvanceCardAdapter<HOLDER : BaseAdvanceCard<BaseAdvanceItem>>(private val fragment: Fragment, private val mData: List<BaseAdvanceItem>) :
    RecyclerView.Adapter<HOLDER>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HOLDER {
        return when (viewType) {
            AdvanceCardType.ADVANCE_CARD_V1.viewType -> AdvanceCardV1.createView(parent)
            else -> AdvanceCardV1.createView(parent)
        } as HOLDER
    }

    override fun onBindViewHolder(holder: HOLDER, position: Int) {
        holder.bindData(fragment, mData[position])
    }

    override fun getItemViewType(position: Int): Int {
        return mData[position].viewType
    }

    override fun getItemCount() = mData.size
}