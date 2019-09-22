package ericdiaz.program.topviewsightseeingcodingchallenge.common.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(application: WeatherApplication): Context {
        return application.applicationContext
    }
}