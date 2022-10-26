package com.example.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("status") @Expose val status:Boolean,@SerializedName("message") @Expose val message:String,@SerializedName("blocked") @Expose val block:String,@SerializedName("user") @Expose val userDetails:User)

