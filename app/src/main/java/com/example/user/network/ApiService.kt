package com.example.user.network

import com.example.model.LoginResponse
import com.example.model.UserResponse
import com.example.util.Constants.LOGIN_ENDPOINT
import retrofit2.Call

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

  @GET("USER_API")
  suspend fun getUserList(@Query("per_page")dataSize:Int):Response<UserResponse>

  @FormUrlEncoded
  @POST(LOGIN_ENDPOINT)
  suspend fun loginApi(@Field("email")email:String, @Field("password")password:String, @Field("lang_id")lang:String, @Field("device_token")token:String):Response<LoginResponse>


}
