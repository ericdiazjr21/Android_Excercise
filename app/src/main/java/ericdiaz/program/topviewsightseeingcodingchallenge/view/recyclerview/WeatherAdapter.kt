package ericdiaz.program.topviewsightseeingcodingchallenge.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ericdiaz.program.topviewsightseeingcodingchallenge.R
import ericdiaz.program.topviewsightseeingcodingchallenge.model.WeekdayWeather

class WeatherAdapter : RecyclerView.Adapter<WeatherViewHolder>() {

    private val weekdayWeathers: MutableList<WeekdayWeather> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weekday_weather_item_view, parent, false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weekdayWeathers.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.onBind(weekdayWeathers[position])
    }

    fun addData(weekdayWeathers: List<WeekdayWeather>) {
        this.weekdayWeathers.let {
            it.clear()
            it.addAll(weekdayWeathers)
        }
        notifyItemRangeChanged(0, weekdayWeathers.size - 1)
    }
}