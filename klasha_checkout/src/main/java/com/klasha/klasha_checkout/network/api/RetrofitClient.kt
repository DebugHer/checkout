package com.klasha.klasha_checkout.network.api

import android.content.Context

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.klasha.klasha_checkout.utils.KlashaApplication
import com.klasha.klasha_checkout.utils.Utils.hasNetwork
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit

object RetrofitClient {
    var context : Context = KlashaApplication.appContext
    private var mClient: OkHttpClient? = null
    private var mGsonConverter: GsonConverterFactory? = null
    val cacheSize = (5 * 1024 * 1024).toLong()
    val myCache = Cache(
        context.cacheDir,
        cacheSize
    )
    private val client: OkHttpClient
        @Throws(NoSuchAlgorithmException::class, KeyManagementException::class)
        get() {
            if (mClient == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val httpBuilder = OkHttpClient.Builder()
                httpBuilder
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)  /// show all JSON in logCat
                mClient = httpBuilder
                    .cache(myCache)
                    .addInterceptor { chain ->
                        var request = chain.request()
                        request = if (hasNetwork(context)!!)
                            request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                        else
                            request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                        chain.proceed(request)
                    }.build()
            }
            return mClient!!
        }

    private val gsonConverter: GsonConverterFactory
        get() {
            if (mGsonConverter == null) {
                mGsonConverter = GsonConverterFactory
                    .create(
                        GsonBuilder()
                            .setLenient()
                            .disableHtmlEscaping()
                            .create()
                    )
            }
            return mGsonConverter!!
        }

    fun apiService() = Retrofit.Builder()
        .baseUrl("BASE_URL")
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(gsonConverter)
        .client(client)
        .build()
        .create(ApiService::class.java)
}