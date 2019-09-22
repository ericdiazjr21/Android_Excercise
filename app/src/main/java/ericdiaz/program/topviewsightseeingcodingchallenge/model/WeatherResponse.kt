package ericdiaz.program.topviewsightseeingcodingchallenge.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weatherForecastTable")
data class WeatherResponse(

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "responseId")
    var responseId: String,

    @ColumnInfo(name = "location")
    @SerializedName("timezone")
    val location: String,

    @ColumnInfo(name = "currentWeather")
    @SerializedName("currently")
    val currentWeather: CurrentWeather,

    @ColumnInfo(name = "dailyForecast")
    @SerializedName("daily")
    val dailyForecast: DailyForecast
)