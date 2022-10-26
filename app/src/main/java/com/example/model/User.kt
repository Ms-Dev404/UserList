package com.example.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class User(@SerializedName("id") @Expose val userId:Int, @SerializedName("access_token") @Expose val bearerToken:String)