package ericdiaz.program.topviewsightseeingcodingchallenge.di

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun bindWeatherActivity()
}