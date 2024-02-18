package br.com.challenge.network
import br.com.challenge.data.repository.ImageCatsAPI
import br.com.challenge.utils.Constants
import br.com.challenge.utils.Constants.TIME_SECONDS
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(TIME_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(TIME_SECONDS, TimeUnit.SECONDS)
        .build()
}

fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL_APP)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun provideService(retrofit: Retrofit): ImageCatsAPI = retrofit.create(ImageCatsAPI::class.java)
