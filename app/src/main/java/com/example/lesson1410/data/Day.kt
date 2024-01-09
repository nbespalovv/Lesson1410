package com.example.lesson1410.data

data class Day(
    val ofWeek: Days,
    val startsWith: Int,
    val lessons: List<Lesson>
)
