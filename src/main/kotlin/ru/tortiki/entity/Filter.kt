package ru.tortiki.entity

data class Filter(var page: Int = 0, var count: Int = 0, var ids: List<String> = emptyList())
