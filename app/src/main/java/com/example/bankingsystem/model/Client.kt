package com.example.bankingsystem.model

data class Client(val name:String,
                  val passportId:String,
                  val email:String,
                  val phoneNumber:String,
                  val password:String,
                  val lastName:String,
                  val account: Account?)
