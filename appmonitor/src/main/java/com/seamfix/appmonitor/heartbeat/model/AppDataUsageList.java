
package com.seamfix.appmonitor.heartbeat.model;
import com.google.gson.annotations.SerializedName;
@SuppressWarnings("unused")
public class AppDataUsageList {

    @SerializedName("appName")
    private String mAppName;
    @SerializedName("dataUsed")
    private String mDataUsed;
    @SerializedName("networkType")
    private String mNetworkType;
    @SerializedName("totalDataUsed")
    private String mTotalDataUsed;

    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String appName) {
        mAppName = appName;
    }

    public String getDataUsed() {
        return mDataUsed;
    }

    public void setDataUsed(String dataUsed) {
        mDataUsed = dataUsed;
    }

    public String getNetworkType() {
        return mNetworkType;
    }

    public void setNetworkType(String networkType) {
        mNetworkType = networkType;
    }

    public String getTotalDataUsed() {
        return mTotalDataUsed;
    }

    public void setTotalDataUsed(String totalDataUsed) {
        mTotalDataUsed = totalDataUsed;
    }

}
