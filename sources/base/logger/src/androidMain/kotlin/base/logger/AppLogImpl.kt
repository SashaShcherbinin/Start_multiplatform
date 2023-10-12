package base.logger

import android.os.Build
import android.util.Log
import org.koin.ext.getFullName
import java.util.regex.Pattern

private const val MAX_TAG_LENGTH = 23
val ANONYMOUS_CLASS: Pattern = Pattern.compile("(\\$\\d+)+$")

internal class AppLogImpl : AppLog {

    constructor()

    private constructor(tag: String) {
        this.tag = tag
    }

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
        // Tag length limit was removed in API 26.
        return if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= 26) {
            tag
        } else {
            tag.substring(0, MAX_TAG_LENGTH)
        }
    }

    override fun d(message: String) {
        Log.d(localTag, message)
    }

    override fun w(message: String) {
        Log.w(localTag, message)
//        Firebase.crashlytics.log(message)
    }


    override fun e(e: Throwable) {
        Log.e(localTag, null, e)
//        Firebase.crashlytics.recordException(e)
    }

    override fun withTag(tag: String): AppLog {
        return AppLogImpl(tag)
    }
}

internal actual fun getAppLog(): AppLog {
    return AppLogImpl()
}
