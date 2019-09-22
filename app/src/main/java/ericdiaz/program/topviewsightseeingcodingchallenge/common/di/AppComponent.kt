package ericdiaz.program.topviewsightseeingcodingchallenge.common.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ericdiaz.program.topviewsightseeingcodingchallenge.data.db.di.DatabaseModule
import ericdiaz.program.topviewsightseeingcodingchallenge.data.network.di.NetworkModule
import ericdiaz.program.topviewsightseeingcodingchallenge.data.repository.di.RepositoryModule
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.di.ViewModelModule
import ericdiaz.program.topviewsightseeingcodingchallenge.view.di.WeatherActivityModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        AppModule::class,
        RepositoryModule::class,
        AndroidInjectionModule::class,
        ViewModelModule::class,
        DatabaseModule::class,
        WeatherActivityModule::class
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