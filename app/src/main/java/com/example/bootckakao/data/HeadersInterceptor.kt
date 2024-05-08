package com.example.bootckakao.data

import com.example.bootckakao.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class HeadersInterceptor @Inject constructor(
) : Interceptor {

    companion object {
        private const val KAKAO_REST_API_KEY = BuildConfig.KAKAO_REST_API_KEY
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "KakaoAK %s".format(KAKAO_REST_API_KEY))
            .build()
        return chain.proceed(request)
    }
}