package br.com.challenge.di

import br.com.challenge.data.repository.ImageRepository
import br.com.challenge.data.repository.ImageRepositoryImp
import br.com.challenge.network.provideConverterFactory
import br.com.challenge.network.provideHttpClient
import br.com.challenge.network.provideRetrofit
import br.com.challenge.network.provideService
import br.com.challenge.view.viewModel.ImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ChallengeModule = module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(), get()) }
    single { provideService(get()) }
    factory { ImageRepository(get()) }
    factory { ImageRepositoryImp(get()) }
    viewModel { ImageViewModel(get(), get()) }
    viewModelOf(::ImageViewModel)
}