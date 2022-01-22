package com.examples.paging3.repository

abstract class BasePagingRepository<T> {
    abstract suspend fun getData(startIndex: Long, endIndex: Long): T?
}