package ericdiaz.program.topviewsightseeingcodingchallenge.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ericdiaz.program.topviewsightseeingcodingchallenge.view.WeatherActivity

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindWeatherActivity(): WeatherActivity
}