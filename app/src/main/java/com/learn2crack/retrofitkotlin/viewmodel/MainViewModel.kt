package com.learn2crack.retrofitkotlin.viewmodel

import android.arch.lifecycle.ViewModel
import com.learn2crack.retrofitkotlin.model.Androidsdf
import com.learn2crack.retrofitkotlin.network.DataHandler
import com.learn2crack.retrofitkotlin.network.RetrofitLiveData


class MainViewModel: ViewModel() {

    val liveData: RetrofitLiveData<List<Androidsdf>> = DataHandler.INSTANCE.organizationHandler.getOrganizations()

    override fun onCleared() {

        liveData.cancel()
    }
}
