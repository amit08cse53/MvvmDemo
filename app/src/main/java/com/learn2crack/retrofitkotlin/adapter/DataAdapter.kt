package com.learn2crack.retrofitkotlin.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color
import com.learn2crack.retrofitkotlin.BR

import com.learn2crack.retrofitkotlin.R
import com.learn2crack.retrofitkotlin.extra.Listener
import com.learn2crack.retrofitkotlin.model.Androidsdf

import kotlinx.android.synthetic.main.recycler_view_row.view.*

class DataAdapter(private val dataList: List<Androidsdf>, private val listener: Listener) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {



    private val colors: Array<String> = arrayOf("#EF5350", "#EC407A", "#AB47BC", "#7E57C2", "#5C6BC0", "#42A5F5")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dataList[position], listener, colors, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.recycler_view_row, parent, false)

        return ViewHolder(binding)

    }

    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(android: Androidsdf, listener: Listener, colors: Array<String>, position: Int) {
            binding.setVariable(BR.data, android)
            binding.setVariable(BR.colour, colors[position % 6])
            binding.root.cl_main_row.setOnClickListener { listener.onItemClick(android) }
            binding.executePendingBindings()
        }
    }
}