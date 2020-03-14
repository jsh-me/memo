package com.example.myapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil {
    companion object {
        val baseUrl = "http://ec2-52-79-156-63.ap-northeast-2.compute.amazonaws.com:8080"

        fun retrofitBuilder(): Retrofit {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain: Interceptor.Chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }
            val client = httpClient.build()
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
        }
    }
}