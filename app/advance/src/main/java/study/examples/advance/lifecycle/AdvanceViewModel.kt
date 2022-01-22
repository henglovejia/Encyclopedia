package study.examples.advance.lifecycle

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import study.examples.advance.feed.AdvancePagingSource
import study.examples.advance.feed.AdvanceRepository

class AdvanceViewModel(application: Application, private val repository: AdvanceRepository) : AndroidViewModel(application) {
    val cards = Pager(
        config = PagingConfig(pageSize = 20, enablePlaceholders = false, initialLoadSize = 20),
        pagingSourceFactory = { AdvancePagingSource(repository) }).flow
}