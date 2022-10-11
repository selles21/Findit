package com.selles.ifindit.di

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.annotation.VisibleForTesting
import com.selles.ifindit.core.remote.HttpClient
import com.selles.ifindit.data.api.FindItService
import com.selles.ifindit.data.repository.FindItRepositoryImpl
import com.selles.ifindit.data.source.FindItDataSourceImpl
import com.selles.ifindit.domain.usecase.GetITunesSearchUseCase
import com.selles.ifindit.presentation.viewmodel.FindItViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier.PRIVATE

val presentationModule = module {
    factory {
        provideOkHttpClient()
    }
    single {
        createRetrofit("https://itunes.apple.com", get())
    }

    factory {
        HttpClient(get())
    }

    viewModel {
        FindItViewModel(
            findItUseCase = GetITunesSearchUseCase(
                findItRepository = FindItRepositoryImpl(
                    findItDataSource = FindItDataSourceImpl(
                        findItService = get<HttpClient>().create(FindItService::class.java)
                    )
                )
            ),
            createMediaPlayer()
        )
    }
}

fun createMediaPlayer(): MediaPlayer {
    return MediaPlayer().apply {
        setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        )
    }
}

@VisibleForTesting(otherwise = PRIVATE)
fun createRetrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient? = null
): Retrofit {
    val retrofitBuilder = Retrofit.Builder()
//            .baseUrl(BuildConfig.API_URL)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())

    okHttpClient?.let { retrofitBuilder.client(okHttpClient) }

    return retrofitBuilder.build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}