package study.examples.advance.feed.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import study.examples.advance.R
import study.examples.advance.databinding.AdvanceListItemTvBinding
import study.examples.advance.model.item.AdvanceCardV1Item
import study.examples.component.ext.viewBinding
import study.examples.router.RouterManager.routerTo

/**
 * @author ZhangHeng
 * @since 2/7/21
 * @email 932805400@qq.com
 * @description
 */

class AdvanceCardV1(itemView: View) : BaseAdvanceCard<AdvanceCardV1Item>(itemView) {
    private val binding by viewBinding<AdvanceListItemTvBinding>()

    companion object {
        fun createView(parent: ViewGroup): AdvanceCardV1 {
            return AdvanceCardV1(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.advance_list_item_tv, parent, false)
            )
        }
    }

    init {
        binding.title.setOnClickListener {
            fragment?.activity?.routerTo(data.uri)
        }
    }

    override fun bindView() {
        binding.title.text = data.title
    }
}