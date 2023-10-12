package base.storage.common.cashe

import kotlinx.datetime.Clock
import kotlin.time.Duration

data class CachePolicy(
    private val time: Duration,
) {

    fun isExpired(createdTime: Long): Boolean {
        val currentTime = getTime()
        return currentTime - createdTime > time.inWholeMilliseconds
    }

    fun getTime(): Long {
        return Clock.System.now().toEpochMilliseconds()
    }
}

fun <T> CachePolicy.createEntry(entity: T): CachedEntry<T> {
    return CachedEntry(entry = entity, createTime = getTime())
}