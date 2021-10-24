package com.examples.feed.fragment

import androidx.paging.PagingDataAdapter
import androidx.viewbinding.ViewBinding
import study.examples.component.fragment.BaseVBFragment

abstract class BasePaging3Fragment<VB : ViewBinding, PA : PagingDataAdapter<*, *>> : BaseVBFragment<VB>() {
    protected lateinit var mAdapter: PA
}