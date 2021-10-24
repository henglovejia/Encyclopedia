package study.examples.advance.feed

import com.examples.paging3.repository.BasePagingRepository
import study.examples.advance.model.item.BaseAdvanceItem

class AdvanceRepository : BasePagingRepository<BaseAdvanceItem>() {
    override fun getData(startIndex: Long, endIndex: Long): List<BaseAdvanceItem> {
        TODO("Not yet implemented")
    }
}