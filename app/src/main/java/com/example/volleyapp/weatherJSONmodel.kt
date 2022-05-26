
package com.example.volleyapp
import com.beust.klaxon.Klaxon
import com.google.gson.annotations.SerializedName
import retrofit2.Converter

class weatherSerializedmodel{
/*
    val klaxon = Klaxon().

    data class Welcome5 (
        val location: Location,
        val current: Current,
        val forecast: Forecast,
        val alerts: Alerts
    ) {
        public fun toSerialized() {

            return klaxon.toSerializedString(this)
        }

        companion object {
            public fun fromSerialized(Serialized: String) = klaxon.parse<Welcome5>(Serialized)
        }
    }

    data class Alerts (
        val alert: List<Any?>
    )

    data class Current (
        @Serialized(name = "last_updated_epoch")
        val lastUpdatedEpoch: Long,

        @Serialized(name = "last_updated")
        val lastUpdated: String,

        @Serialized(name = "temp_c")
        val tempC: Double,

        @Serialized(name = "temp_f")
        val tempF: Double,

        @Serialized(name = "is_day")
        val isDay: Long,

        val condition: Condition,

        @Serialized(name = "wind_mph")
        val windMph: Double,

        @Serialized(name = "wind_kph")
        val windKph: Double,

        @Serialized(name = "wind_degree")
        val windDegree: Long,

        @Serialized(name = "wind_dir")
        val windDir: String,

        @Serialized(name = "pressure_mb")
        val pressureMB: Double,

        @Serialized(name = "pressure_in")
        val pressureIn: Double,

        @Serialized(name = "precip_mm")
        val precipMm: Double,

        @Serialized(name = "precip_in")
        val precipIn: Double,

        val humidity: Long,
        val cloud: Long,

        @Serialized(name = "feelslike_c")
        val feelslikeC: Double,

        @Serialized(name = "feelslike_f")
        val feelslikeF: Double,

        @Serialized(name = "vis_km")
        val visKM: Double,

        @Serialized(name = "vis_miles")
        val visMiles: Double,

        val uv: Double,

        @Serialized(name = "gust_mph")
        val gustMph: Double,

        @Serialized(name = "gust_kph")
        val gustKph: Double,

        @Serialized(name = "air_quality")
        val airQuality: Map<String, Double>
    )

    data class Condition (
        val text: Text,
        val icon: Icon,
        val code: Long
    )

    enum class Icon(val value: String) {
        CDNWeatherapiCOMWeather64X64Day113PNG("//cdn.weatherapi.com/weather/64x64/day/113.png"),
        CDNWeatherapiCOMWeather64X64Night113PNG("//cdn.weatherapi.com/weather/64x64/night/113.png");

        companion object {
            public fun fromValue(value: String): Icon = when (value) {
                "//cdn.weatherapi.com/weather/64x64/day/113.png"   -> CDNWeatherapiCOMWeather64X64Day113PNG
                "//cdn.weatherapi.com/weather/64x64/night/113.png" -> CDNWeatherapiCOMWeather64X64Night113PNG
                else                                               -> throw IllegalArgumentException()
            }
        }
    }

    enum class Text(val value: String) {
        Clear("Clear"),
        Sunny("Sunny");

        companion object {
            public fun fromValue(value: String): Text = when (value) {
                "Clear" -> Clear
                "Sunny" -> Sunny
                else    -> throw IllegalArgumentException()
            }
        }
    }

    data class Forecast (
        val forecastday: List<Forecastday>
    )

    data class Forecastday (
        val date: String,

        @Serialized(name = "date_epoch")
        val dateEpoch: Long,

        val day: Day,
        val astro: Astro,
        val hour: List<Hour>
    )

    data class Astro (
        val sunrise: String,
        val sunset: String,
        val moonrise: String,
        val moonset: String,

        @Serialized(name = "moon_phase")
        val moonPhase: String,

        @Serialized(name = "moon_illumination")
        val moonIllumination: String
    )

    data class Day (
        @Serialized(name = "maxtemp_c")
        val maxtempC: Double,

        @Serialized(name = "maxtemp_f")
        val maxtempF: Double,

        @Serialized(name = "mintemp_c")
        val mintempC: Double,

        @Serialized(name = "mintemp_f")
        val mintempF: Double,

        @Serialized(name = "avgtemp_c")
        val avgtempC: Double,

        @Serialized(name = "avgtemp_f")
        val avgtempF: Double,

        @Serialized(name = "maxwind_mph")
        val maxwindMph: Double,

        @Serialized(name = "maxwind_kph")
        val maxwindKph: Double,

        @Serialized(name = "totalprecip_mm")
        val totalprecipMm: Double,

        @Serialized(name = "totalprecip_in")
        val totalprecipIn: Double,

        @Serialized(name = "avgvis_km")
        val avgvisKM: Double,

        @Serialized(name = "avgvis_miles")
        val avgvisMiles: Double,

        val avghumidity: Double,

        @Serialized(name = "daily_will_it_rain")
        val dailyWillItRain: Long,

        @Serialized(name = "daily_chance_of_rain")
        val dailyChanceOfRain: Long,

        @Serialized(name = "daily_will_it_snow")
        val dailyWillItSnow: Long,

        @Serialized(name = "daily_chance_of_snow")
        val dailyChanceOfSnow: Long,

        val condition: Condition,
        val uv: Double
    )

    data class Hour (
        @Serialized(name = "time_epoch")
        val timeEpoch: Long,

        val time: String,

        @Serialized(name = "temp_c")
        val tempC: Double,

        @Serialized(name = "temp_f")
        val tempF: Double,

        @Serialized(name = "is_day")
        val isDay: Long,

        val condition: Condition,

        @Serialized(name = "wind_mph")
        val windMph: Double,

        @Serialized(name = "wind_kph")
        val windKph: Double,

        @Serialized(name = "wind_degree")
        val windDegree: Long,

        @Serialized(name = "wind_dir")
        val windDir: String,

        @Serialized(name = "pressure_mb")
        val pressureMB: Double,

        @Serialized(name = "pressure_in")
        val pressureIn: Double,

        @Serialized(name = "precip_mm")
        val precipMm: Double,

        @Serialized(name = "precip_in")
        val precipIn: Double,

        val humidity: Long,
        val cloud: Long,

        @Serialized(name = "feelslike_c")
        val feelslikeC: Double,

        @Serialized(name = "feelslike_f")
        val feelslikeF: Double,

        @Serialized(name = "windchill_c")
        val windchillC: Double,

        @Serialized(name = "windchill_f")
        val windchillF: Double,

        @Serialized(name = "heatindex_c")
        val heatindexC: Double,

        @Serialized(name = "heatindex_f")
        val heatindexF: Double,

        @Serialized(name = "dewpoint_c")
        val dewpointC: Double,

        @Serialized(name = "dewpoint_f")
        val dewpointF: Double,

        @Serialized(name = "will_it_rain")
        val willItRain: Long,

        @Serialized(name = "chance_of_rain")
        val chanceOfRain: Long,

        @Serialized(name = "will_it_snow")
        val willItSnow: Long,

        @Serialized(name = "chance_of_snow")
        val chanceOfSnow: Long,

        @Serialized(name = "vis_km")
        val visKM: Double,

        @Serialized(name = "vis_miles")
        val visMiles: Double,

        @Serialized(name = "gust_mph")
        val gustMph: Double,

        @Serialized(name = "gust_kph")
        val gustKph: Double,

        val uv: Double
    )

    data class Location (
        val name: String,
        val region: String,
        val country: String,
        val lat: Double,
        val lon: Double,

        @Serialized(name = "tz_id")
        val tzID: String,

        @Serialized(name = "localtime_epoch")
        val localtimeEpoch: Long,

        val localtime: String
    )
*/
}

