package com.example.viewmodel_addusers_jan18_trint02

data class User(
    var firstName : String,
    var lastName : String
){
    override fun toString(): String {
        return "$firstName $lastName"
    }
}