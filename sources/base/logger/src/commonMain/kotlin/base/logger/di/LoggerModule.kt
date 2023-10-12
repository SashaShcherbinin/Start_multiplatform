package base.logger.di

import base.logger.getAppLog
import org.koin.core.module.Module
import org.koin.dsl.module

fun loggerModule(): Module = module {
    factory { getAppLog() }
}
