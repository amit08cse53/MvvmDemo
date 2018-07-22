package com.learn2crack.retrofitkotlin

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

import com.learn2crack.retrofitkotlin.adapter.DataAdapter
import com.learn2crack.retrofitkotlin.extra.Listener
import com.learn2crack.retrofitkotlin.model.Androidsdf
import com.learn2crack.retrofitkotlin.viewmodel.MainViewModel


class MainActivity : AppCompatActivity(), Listener {

    private val TAG = MainActivity::class.java.simpleName

//    private val BASE_URL = "https://learn2crack-json.herokuapp.com/api/android"
    private val BASE_URL = "https://learn2crack-json.herokuapp.com"

    private var mAndroidArrayList: List<Androidsdf>? = null

    private var mAdapter: DataAdapter? = null

    private lateinit var  rv_android_list : RecyclerView

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_android_list = findViewById(R.id.rv_android_list)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        mCompositeDisposable = CompositeDisposable()
//
        initRecyclerView()

        ViewModelProviders.of(this)
                .get(MainViewModel::class.java)
                .liveData.observe(this,android.arch.lifecycle.Observer{response ->

            mAndroidArrayList = response?.toList()

            mAdapter = DataAdapter(mAndroidArrayList!!,this)
            rv_android_list.adapter = mAdapter
        })
//
//        loadJSON()
    }

    private fun initRecyclerView() {

        rv_android_list.setHasFixedSize(true)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_android_list.layoutManager = layoutManager
    }

//    private fun loadJSON() {
//
//        val requestInterface = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build().create(RequestInterface::class.java)
//
//        mCompositeDisposable?.add(requestInterface.getData()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::handleResponse, this::handleError))
//
//    }

//    private fun handleResponse(androidList: List<Androidsdf>) {
//
//        mAndroidArrayList = ArrayList(androidList)
//        mAdapter = DataAdapter(mAndroidArrayList!!, this)
//
//        rv_android_list.adapter = mAdapter
//    }
//
//    private fun handleError(error: Throwable) {
//
//        Log.d(TAG, error.localizedMessage)
//
//        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
//    }

    override fun onItemClick(android: Androidsdf) {

        Toast.makeText(this, "${android.name} Clicked !", Toast.LENGTH_SHORT).show()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        mCompositeDisposable?.clear()
//    }
}
