package ericdiaz.program.topviewsightseeingcodingchallenge.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import ericdiaz.program.topviewsightseeingcodingchallenge.R

class WeatherActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_layout)
        AndroidInjection.inject(this)
    }
}