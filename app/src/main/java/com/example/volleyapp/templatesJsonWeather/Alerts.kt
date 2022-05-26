package com.example.volleyapp

import com.google.gson.annotations.SerializedName


data class Alerts (

  @SerializedName("alert" ) var alert : ArrayList<String> = arrayListOf()

)