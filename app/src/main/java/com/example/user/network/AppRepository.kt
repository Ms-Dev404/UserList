package com.example.user.network

import android.util.Log
import com.example.model.LoginResponse
import com.example.util.ApiSafeRequest
import com.example.util.AppLogger
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class AppRepository(private val apiService: ApiService?):ApiSafeRequest() {

suspend fun getUsers()= executeRequest{
    apiService!!.getUserList(30) }
    init {


    }
    suspend fun signIn(userName:String,password:String)= executeRequest {

        apiService!!.loginApi(userName,password,"en","sss")



    }



}
