package com.example.user.ui.viewmodel


import android.util.Log
import androidx.lifecycle.*
import com.example.model.LoginResponse
import com.example.model.UserResponse
import com.example.util.AppLogger
import com.example.user.network.AppRepository
import com.example.util.AppCoroutine
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val repository: AppRepository?) : ViewModel() {
 private val set_userList = MutableLiveData<UserResponse>()
 val userList: LiveData<UserResponse> get() = set_userList

 private val _loginResponse = MutableLiveData<LoginResponse>()
 val loginResponse: LiveData<LoginResponse> get() = _loginResponse


 fun getList(){

  viewModelScope.launch {
   try {


   set_userList.value = repository!!.getUsers()


  }catch (e:Exception){

   AppLogger.logError(e.stackTraceToString())
   set_userList.value = UserResponse(arrayListOf(),e.localizedMessage)
   }

  }



 }

 fun signIn(userName:String,password:String){
  try {


  AppCoroutine.run {

   repository?.let {

   val response =it.signIn(userName, password)

   _loginResponse.postValue(response)

    Log.e("TAG", "onCreate: "+ Gson().toJson(response) )
   }
  }
  }catch (e:Exception){
   Log.e("TAG", "signIn: "+e.localizedMessage )}
 }



 override fun onCleared() {
  super.onCleared()


 }


}