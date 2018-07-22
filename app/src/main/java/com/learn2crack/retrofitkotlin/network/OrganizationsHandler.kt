package com.learn2crack.retrofitkotlin.network

import com.learn2crack.retrofitkotlin.model.Androidsdf

class OrganizationsHandler(val organizationsSerivce: RequestInterface) {

    fun getOrganizations() : RetrofitLiveData<List<Androidsdf>> = RetrofitLiveData(organizationsSerivce.getData())

}
