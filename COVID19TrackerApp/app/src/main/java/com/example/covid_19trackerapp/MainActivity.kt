package com.example.covid_19trackerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val response= withContext(Dispatchers.IO){ Client.api.execute() }
            if(response.isSuccessful)
            {
                val data=Gson().fromJson(response.body?.string(), Response::class.java)
                launch(Dispatchers.Main){
                    bindCombinedData(data.statewise[0])
                    bindStateWiseData(data.statewise.subList(0,data.statewise.size))
                }
            }
        }




    }
    private fun bindStateWiseData(subList: List<stateWiseItem>){
        listAdapter = ListAdapter(subList)
        list.addHeaderView(LayoutInflater.from(this).inflate(R.layout.list_header, list,false))
        list.adapter=listAdapter
    }
    private fun bindCombinedData(data: stateWiseItem){
        confirmedTv.text=data.confirmed
        activeTv.text=data.active
        recoveredTv.text=data.recorved
        deceasedTv.text=data.deaths

    }
}


