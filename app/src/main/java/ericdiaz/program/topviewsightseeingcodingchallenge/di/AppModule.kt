package ericdiaz.program.topviewsightseeingcodingchallenge.di

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