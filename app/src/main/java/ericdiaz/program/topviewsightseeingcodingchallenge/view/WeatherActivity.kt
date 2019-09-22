package ericdiaz.program.topviewsightseeingcodingchallenge.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import ericdiaz.program.topviewsightseeingcodingchallenge.R
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.State
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.StateDescriptor
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.WeatherViewModel
import ericdiaz.program.topviewsightseeingcodingchallenge.viewmodel.WeatherViewModelFactory
import kotlinx.android.synthetic.main.activity_weather_layout.*
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
                    is State.Success -> {
                        hideProgressBar()

                        hideNoDataTextView()

                        loadDataIntoViews(state)

                        showWeatherViews()
                    }
                    is State.Failure -> {
                        if (state.stateDescriptor == StateDescriptor.NO_DATA_SOURCE_AVAILABLE) {
                            showNoDataTextView()
                        }
                        hideProgressBar()

                        showSnackBar(state.stateDescriptor)
                    }
                    is State.Loading -> {
                        hideWeatherViews()

                        hideNoDataTextView()

                        showProgressBar()
                    }
                }
            })
    }

    private fun loadDataIntoViews(state: State.Success) {

        if (state.stateDescriptor == StateDescriptor.FROM_DATABASE) {
            showSnackBar(state.stateDescriptor)
        }

        val weatherResponse = state.weatherResponse
        val currentWeather = weatherResponse.currentWeather

        current_location_text_view.text = weatherResponse.location
        last_updated_text_view.text = currentWeather.date
        current_temperature_text_view.text = currentWeather.temperature.toString()
    }


    private fun showWeatherViews() {
        current_location_text_view.visibility = View.VISIBLE
        current_temperature_text_view.visibility = View.VISIBLE
        last_updated_text_view.visibility = View.VISIBLE
        current_weather_icon_image_view.visibility = View.VISIBLE
        daily_forecast_recycler_view.visibility = View.VISIBLE
    }

    private fun hideWeatherViews() {
        current_location_text_view.visibility = View.INVISIBLE
        current_temperature_text_view.visibility = View.INVISIBLE
        last_updated_text_view.visibility = View.INVISIBLE
        current_weather_icon_image_view.visibility = View.INVISIBLE
        daily_forecast_recycler_view.visibility = View.INVISIBLE
    }

    private fun showNoDataTextView() {
        no_data_text_view.visibility = View.VISIBLE
    }

    private fun hideNoDataTextView() {
        no_data_text_view.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        loading_progress_bar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        loading_progress_bar.visibility = View.INVISIBLE
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(loading_progress_bar, message, Snackbar.LENGTH_LONG)
    }

}