package study.examples.advance.feed

import androidx.paging.PagingState
import com.examples.paging3.source.BasePagingSource
import study.examples.advance.model.item.BaseAdvanceItem

class AdvancePagingSource(private val repository:) : BasePagingSource<Int, BaseAdvanceItem>() {
    override fun getRefreshKey(state: PagingState<Int, BaseAdvanceItem>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BaseAdvanceItem> {
        TODO("Not yet implemented")
    }
}