package com.seamfix.appmonitor.heartbeat

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.seamfix.appmonitor.heartbeat.remote.HeartbeatWorker
import com.sf.rest.request.device.DeviceHeartBeat
import java.util.*


const val HEARTBEAT_UUID = "heartbeat_uuid"
const val NO_VALUE_SET = "NO_VALUE_SET"

/*** Saves the uuid of the current upload work so that it can be retrieved when
 * the app is closed or fragment restarts.
 */
fun HeartBeat.saveCurrentUploadWorkInformation(context: Context, uuid: UUID){
    val sharedPref: SharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    val editor = sharedPref.edit()
    editor.putString(HEARTBEAT_UUID, uuid.toString())
    editor.apply()

    Log.e("HeartBeat", "Saving upload work info::: uuid: $uuid")
}


/*** Returns the uuid of the current upload work so that it can be used to indicate
 * that a work is already in progress when the app is closed or fragment restarts.
 */
fun HeartBeat.getCurrentUploadWorkInformation(context: Context): UUID? {
    val sharedPref: SharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    val id = sharedPref.getString(HEARTBEAT_UUID, NO_VALUE_SET)

    return if(id != null && id != NO_VALUE_SET){

        val uuid = java.util.UUID.fromString(id)

        Log.e("HeartBeat", "Fetching existing upload work::: uuid: $uuid")
        uuid

    }else{
       null
    }
}


fun HeartbeatWorker.getDeviceHeartBeat(): DeviceHeartBeat {

}