package com.byungtak.lookingfor.di

import com.byungtak.lookingfor.Constants
import com.byungtak.lookingfor.LookingForApp
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ApplicationRepositoryModule.ProvideModule::class])
internal interface ApplicationRepositoryModule {

    @Module
    class ProvideModule {
        @Singleton
        @Provides
        fun provideOkHttpClient(): OkHttpClient {
            val loggingIntercepter = HttpLoggingInterceptor()
            loggingIntercepter.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .addInterceptor(loggingIntercepter)
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()
        }

        @Singleton
        @Provides
        fun retrofit(okHttpClient: OkHttpClient): Retrofit
                = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        @Singleton
        @Provides
        fun provideEmpathyService(retrofit: Retrofit): LookingForApp = retrofit.create(LookingForApp::class.java)
    }

}
