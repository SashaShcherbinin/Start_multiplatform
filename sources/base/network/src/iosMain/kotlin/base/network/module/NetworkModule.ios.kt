package base.network.module

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual fun getEngineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> {
    return Darwin
}
