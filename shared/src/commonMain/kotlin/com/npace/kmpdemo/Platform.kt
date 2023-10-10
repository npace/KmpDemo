package com.npace.kmpdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform