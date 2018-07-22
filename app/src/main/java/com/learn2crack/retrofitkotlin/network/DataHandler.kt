package com.learn2crack.retrofitkotlin.network

import com.learn2crack.retrofitkotlin.extra.Constant
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DataHandler private constructor() {

    companion object Singleton {
        val INSTANCE: DataHandler by lazy { DataHandler() }
    }

    val organizationHandler: OrganizationsHandler
    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()

        organizationHandler = OrganizationsHandler(retrofit.create(RequestInterface::class.java))
    }
}