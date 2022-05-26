package com.example.volleyapp

import com.google.gson.annotations.SerializedName


data class ExampleJsonWeather (

  @SerializedName("location" ) var location : Location? = Location(),
  @SerializedName("current"  ) var current  : Current?  = Current(),
  @SerializedName("forecast" ) var forecast : Forecast? = Forecast(),
  @SerializedName("alerts"   ) var alerts   : Alerts?   = Alerts()

)