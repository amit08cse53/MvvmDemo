package com.learn2crack.retrofitkotlin.network


import com.learn2crack.retrofitkotlin.model.Androidsdf
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RequestInterface {

    @GET("api/android")
//    fun getData() : Observable<List<Androidsdf>>
    fun getData() : Call<List<Androidsdf>>
}
