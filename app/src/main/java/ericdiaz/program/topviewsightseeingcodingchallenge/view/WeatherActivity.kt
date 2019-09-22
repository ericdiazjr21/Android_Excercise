package ericdiaz.program.topviewsightseeingcodingchallenge.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import ericdiaz.program.topviewsightseeingcodingchallenge.R
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.State
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.WeatherViewModel
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.WeatherViewModelFactory
import javax.inject.Inject

class WeatherActivity : AppCompatActivity() {

    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModelFactory
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_layout)
        AndroidInjection.inject(this)

        weatherViewModel =
            ViewModelProviders.of(this, weatherViewModelFactory).get(WeatherViewModel::class.java)

        weatherViewModel.getWeatherData().observe(this,
            Observer<State> { state ->
                when (state) {
                    is State.Success -> Log.d("sasuke", state.weatherResponse.toString())
                    is State.Failure -> Log.d("sasuke", state.throwable.toString())
                    State.Loading -> TODO()
                }
            })
    }
}