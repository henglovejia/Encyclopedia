package com.examples.feed.fragment

import androidx.paging.PagingDataAdapter
import study.examples.component.fragment.BaseVBFragment

abstract class BasePaging3Fragment<PA : PagingDataAdapter<*, *>> : BaseVBFragment() {
    protected lateinit var mAdapter: PA
}