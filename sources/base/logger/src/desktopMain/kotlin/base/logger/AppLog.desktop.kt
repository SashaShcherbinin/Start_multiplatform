package base.logger

import org.koin.ext.getFullName
import java.util.logging.Level
import java.util.logging.Logger
import java.util.regex.Pattern

val ANONYMOUS_CLASS: Pattern = Pattern.compile("(\\$\\d+)+$")

internal class AppLogImpl : AppLog {
    private val logger = Logger.getLogger(AppLogImpl::class.java.name)
    private var tag: String? = null

    private val fqcnIgnore: List<String> = listOf(
        AppLogImpl::class.getFullName(),
    )

    private val localTag: String
        get() = tag ?: Throwable().stackTrace
            .first { it.className !in fqcnIgnore }
            .let(::createStackElementTag)

    private fun createStackElementTag(element: StackTraceElement): String {
        var tag = element.className.substringAfterLast('.')
        val m = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        return tag
    }

    override fun d(message: String) {
        logger.log(Level.FINE, "$localTag - $message")
    }

    override fun w(message: String) {
        logger.log(Level.WARNING, "$localTag - $message")
    }

    override fun e(e: Throwable) {
        logger.log(Level.SEVERE, "$localTag - ${e.message}", e)
    }

    override fun withTag(tag: String): AppLog {
        val newLog = AppLogImpl()
        newLog.tag = tag
        return newLog
    }
}

actual fun getAppLog(): AppLog {
    return AppLogImpl()
}