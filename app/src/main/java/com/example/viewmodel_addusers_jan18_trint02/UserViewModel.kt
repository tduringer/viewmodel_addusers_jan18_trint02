package com.example.viewmodel_addusers_jan18_trint02

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {


    private var _users : MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users
    private val userList: MutableList<User> = mutableListOf()

    //val user : LiveData<String> get() = _user

    fun addUser(user : User) {
        userList.add(user)
        _users.value = userList
        //val builder = java.lang.StringBuilder()

        //var usersLongString = builder.append(inputUser.toString())
        //_user.value = usersLongString.toString()
    }


//    private var _user : MutableLiveData<User> = MutableLiveData()
//    val user : LiveData<User> get() = _user
//
//    private var _userList : MutableLiveData<List<User>> = MutableLiveData()
//    val userList : LiveData<List<User>> get() = _userList
//
//    fun addUser(inputUser : User) {
//        val userString : String = inputUser.toString()
//        _userList.value = _userList.setValue(userString)
//    }
}