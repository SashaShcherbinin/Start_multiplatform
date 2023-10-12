package base.logger

import platform.Foundation.NSLog

internal class AppLogImpl : AppLog {

    constructor()

    private constructor(tag: String) {
        this.tag = tag
    }

    private var tag: String? = null

    private val localTag: String
        get() = tag ?: "AppLog"

    override fun d(message: String) {
        NSLog("DEBUG: $localTag - $message")
    }

    override fun w(message: String) {
        NSLog("WARN: $localTag - $message")
    }

    override fun e(e: Throwable) {
        NSLog("ERROR: $localTag - ${e.message}")
    }

    override fun withTag(tag: String): AppLog {
        return AppLogImpl(tag)
    }
}

internal actual fun getAppLog(): AppLog = AppLogImpl()
