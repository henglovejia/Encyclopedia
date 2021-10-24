package com.examples.paging3.source

import androidx.paging.rxjava3.RxPagingSource

abstract class BaseRxPagingSource<Key : Any, Value : Any> : RxPagingSource<Key, Value>() {
}