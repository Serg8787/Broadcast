package com.tsybulnik.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val action = p1?.action

        when(action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->{
                Log.d("MyReceiver","ACTION_AIRPLANE_MODE_CHANGED")
                Toast.makeText(p0,"ACTION_AIRPLANE_MODE_CHANGED",Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BATTERY_LOW->{
                val turnOn = p1.getBooleanExtra("state",false)
                Log.d("MyReceiver","ACTION_AIRPLANE_MODE_CHANGED")
                Toast.makeText(p0,"ACTION_BATTERY_LOW Turn On $turnOn",Toast.LENGTH_LONG).show()
            }

        }
    }
}