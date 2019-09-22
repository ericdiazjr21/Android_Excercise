package ericdiaz.program.topviewsightseeingcodingchallenge.view.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ericdiaz.program.topviewsightseeingcodingchallenge.view.WeatherActivity

@Module
abstract class WeatherActivityModule {

    @ContributesAndroidInjector
    abstract fun bindWeatherActivity(): WeatherActivity

}