package com.npace.kmpdemo

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val localServerHost: String = "http://10.0.2.2:8080"
}

actual fun getPlatform(): Platform = AndroidPlatform()
