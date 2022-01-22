package study.examples.advance.feed

import android.content.res.AssetManager
import com.examples.paging3.repository.BasePagingRepository
import study.examples.advance.model.AdvanceIndexResponse
import study.examples.advance.network.AdvanceApiManager

class AdvanceRepository(private val assetManager: AssetManager?) : BasePagingRepository<AdvanceIndexResponse>() {
    private val mApiManager = AdvanceApiManager()
    override suspend fun getData(startIndex: Long, endIndex: Long): AdvanceIndexResponse {
        return mApiManager.getIndex(assetManager)
    }
}