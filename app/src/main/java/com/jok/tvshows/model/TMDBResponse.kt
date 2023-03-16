package com.jok.tvshows.model

data class TMDBResponse(
    val page: Int = 0,
    val results: List<Result> = listOf(),
    val total_pages: Int = 0,
    val total_results: Int = 0
)