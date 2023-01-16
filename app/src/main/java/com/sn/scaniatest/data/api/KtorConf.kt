package com.sn.scaniatest.data.api

import android.util.Log
import com.sn.scaniatest.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.cio.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import javax.inject.Singleton

class KtorModule {
    companion object {
        private const val TIME_OUT = 60_000L
        val provideKtor: HttpClient get() = HttpClient(OkHttp) {
            install(HttpCache)
            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = 5)
                exponentialDelay()
            }
            expectSuccess = true
            defaultRequest {
                url(BuildConfig.BASE_URL)
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }

            install(ContentNegotiation) {
                gson{
                    setPrettyPrinting()
                }
            }

            install(HttpTimeout) {
                connectTimeoutMillis = TIME_OUT
                socketTimeoutMillis = TIME_OUT
                requestTimeoutMillis = TIME_OUT
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.v("HttpLogger-HTTP status", "${response.status.value}")
                    Log.v("HttpLogger-Response:", response.toString())
                }
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("Logger Ktor =>", message)
                    }

                }
                level = LogLevel.ALL
            }
        }.also {
            it.plugin(HttpSend).intercept { request ->
                val originalCall = execute(request)
                if (originalCall.response.status.value !in 100..399) {
                    execute(request)
                } else {
                    originalCall
                }
            }

        }
    }
}


@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun bindsNetwork(
        ktorNetwork: KtorNetwork,
    ): NetworkDataSource
}