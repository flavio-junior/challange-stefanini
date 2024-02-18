package br.com.challenge.di

import br.com.challenge.data.repository.ImageCatsRepository
import br.com.challenge.data.repository.ImageCatsRepositoryImp
import br.com.challenge.network.provideConverterFactory
import br.com.challenge.network.provideHttpClient
import br.com.challenge.network.provideRetrofit
import br.com.challenge.network.provideService
import br.com.challenge.view.viewModel.ImageCatsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ImageCatsModule = module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(), get()) }
    single { provideService(get()) }
    factory { ImageCatsRepository(get()) }
    factory { ImageCatsRepositoryImp(get()) }
    viewModel { ImageCatsViewModel(get(), get()) }
    viewModelOf(::ImageCatsViewModel)
}