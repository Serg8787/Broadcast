package com.tsybulnik.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {

        when(p1?.action){
            "loaded" -> {
                val percent = p1.getIntExtra("percent",0)
                Toast.makeText(p0,"loaded $percent",Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->{
                Log.d("MyReceiver","ACTION_AIRPLANE_MODE_CHANGED")
                Toast.makeText(p0,"ACTION_AIRPLANE_MODE_CHANGED",Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BATTERY_LOW->{
                val turnOn = p1.getBooleanExtra("state",false)
                Log.d("MyReceiver","ACTION_AIRPLANE_MODE_CHANGED")
                Toast.makeText(p0,"ACTION_BATTERY_LOW Turn On $turnOn",Toast.LENGTH_LONG).show()
            }
            ACTION -> {
                val count = p1.getIntExtra(EXTRA_COUNT,0)
                Toast.makeText(p0, "ACTION $count", Toast.LENGTH_LONG).show()
            }
        }
    }
    companion object{
        const val ACTION = "ACTION"
        const val EXTRA_COUNT = "COUNT"
    }
}