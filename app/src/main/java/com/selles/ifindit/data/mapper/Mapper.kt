package com.selles.ifindit.data.mapper

interface Mapper<T, U> {
    fun map(entry: T): U
}
