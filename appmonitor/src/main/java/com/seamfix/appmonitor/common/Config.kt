package com.seamfix.appmonitor.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class Config(var baseURL: String, var headers: List<Pair<String, String>>, var endPoints: String = "")