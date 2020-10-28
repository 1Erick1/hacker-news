package com.example.hackernews.core

import android.content.Context
import org.koin.core.Koin
import java.util.*
import kotlin.math.abs

fun Date.timeAgo(): String{
    val diff = Date().time - this.time

    val seconds = abs(diff) / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    return when {
        seconds<60 -> {
            "Just now"
        }
        minutes<60 -> {
            "${minutes}m"
        }
        hours<23 -> {
            "${hours}h"
        }
        else -> {
            "${days}d"
        }
    }

}