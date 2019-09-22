package ericdiaz.program.topviewsightseeingcodingchallenge.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ericdiaz.program.topviewsightseeingcodingchallenge.network.di.NetworkModule
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.di.RepositoryModule
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.di.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class,
        RepositoryModule::class,
        AndroidInjectionModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(weatherApplication: WeatherApplication): Builder

        fun build(): AppComponent
    }

    fun inject(weatherApplication: WeatherApplication)
}