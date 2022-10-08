package com.mypilog.data_remote.di

import com.mypilog.data_remote.network.asset.AssetService
import com.mypilog.data_remote.network.expense.ExpenseService
import com.mypilog.data_remote.network.income.IncomeService
import com.mypilog.data_remote.network.liability.LiabilityService
import com.mypilog.data_remote.network.user.UserService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .build()

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.61.229:8080/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    fun provideExpenseService(retrofit: Retrofit): ExpenseService =
        retrofit.create(ExpenseService::class.java)

    @Provides
    fun provideIncomeService(retrofit: Retrofit): IncomeService =
        retrofit.create(IncomeService::class.java)

    @Provides
    fun provideAssetService(retrofit: Retrofit): AssetService =
        retrofit.create(AssetService::class.java)

    @Provides
    fun provideLiabilityService(retrofit: Retrofit): LiabilityService =
        retrofit.create(LiabilityService::class.java)

    @Provides
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
}