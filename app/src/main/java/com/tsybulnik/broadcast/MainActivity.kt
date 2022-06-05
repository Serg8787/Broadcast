package com.tsybulnik.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private val receiver = object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            if (p1?.action =="loaded"){
                val percent = p1.getIntExtra("percent",0)
                progressBar.setProgress(percent,true)

            }
        }
    }

    private var countOfClick = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

        findViewById<Button>(R.id.btBroadcast).setOnClickListener {

           Intent(MyReceiver.ACTION).apply {
               putExtra(MyReceiver.EXTRA_COUNT,countOfClick++)
               sendBroadcast(this)
           }

        }

        val intentFilter = IntentFilter().apply {
            addAction("loaded")
        }
        registerReceiver(receiver,intentFilter)

        Intent(this,MyService::class.java).apply {
            startService(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }


}