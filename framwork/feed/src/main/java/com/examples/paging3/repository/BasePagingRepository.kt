package com.examples.paging3.repository

abstract class BasePagingRepository<T> {
    abstract fun getData(startIndex: Long, endIndex: Long): List<T>
}