package com.examples.paging3.source

import androidx.paging.PagingSource

abstract class BasePagingSource<Key : Any, Value : Any> : PagingSource<Key, Value>() {

}