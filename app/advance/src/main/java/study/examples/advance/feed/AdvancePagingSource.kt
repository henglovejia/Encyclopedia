package study.examples.advance.feed

import androidx.paging.PagingState
import com.examples.paging3.source.BasePagingSource
import study.examples.advance.model.item.BaseAdvanceItem

class AdvancePagingSource(private val repository: AdvanceRepository) : BasePagingSource<Int, BaseAdvanceItem>() {
    override fun getRefreshKey(state: PagingState<Int, BaseAdvanceItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BaseAdvanceItem> {
        val pos = params.key ?: 0
        val startIndex = pos * params.loadSize + 1
        val endIndex = (pos + 1) * params.loadSize
        return try {
            // 从数据库拉去数据
            val data = repository.getData(startIndex.toLong(), endIndex.toLong())
            // 返回你的分页结果，并填入前一页的 key 和后一页的 key
            LoadResult.Page(
                data.cards,
                if (pos <= 0) null else pos - 1,
                if (data.cards.isNullOrEmpty()) null else pos + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}