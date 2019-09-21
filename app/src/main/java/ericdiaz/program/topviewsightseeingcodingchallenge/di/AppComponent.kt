package ericdiaz.program.topviewsightseeingcodingchallenge.di

import dagger.BindsInstance
import dagger.Component
import ericdiaz.program.topviewsightseeingcodingchallenge.network.di.NetworkModule
import ericdiaz.program.topviewsightseeingcodingchallenge.repository.di.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class,
        RepositoryModule::class]
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