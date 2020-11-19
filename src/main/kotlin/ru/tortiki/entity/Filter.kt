package ru.tortiki.entity

data class Filter(var ids: List<String> = emptyList(), var from: Int, var count: Int)
