//package com.doancea.quotesapp.retrofit
//
//import dagger.Provides
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Named
//
//const val BASE_URL = "https://api.cert.tastyworks.com/" //TODO: Make this a build config value
//
//object RetrofitBuilder {
//    @Provides
//    fun provideRetrofitBuilder(
//        @Named("default") okHttpClient: OkHttpClient
//    ): Retrofit.Builder =
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//}