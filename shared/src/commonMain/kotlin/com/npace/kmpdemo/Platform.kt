package com.npace.kmpdemo

interface Platform {
    val name: String
    val localServerHost: String
}

expect fun getPlatform(): Platform
