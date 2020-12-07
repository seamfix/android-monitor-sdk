
package com.seamfix.appmonitor.heartbeat.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
@SuppressWarnings("unused")
public class DeviceHeartBeatRequest {

    private List<AppDataUsageList> appDataUsageList;
    private String appVersion;
    private String availableRam;
    private String availableStorage;
    private Boolean batteryChargeStatus;
    private Double clientUptime;
    private String deviceBatteryCharge;
    private Boolean kioskMode;
    private Double latitude;
    private Boolean localTimeCorrect;
    private String locationGenerationTime;
    private Double loginUptime;
    private Double longitude;
    private String macAddress;
    private String networkName;
    private String networkType;
    private String osName;
    private String osVersion;
    private String processorSpeed;
    private String processorType;
    private String ramSize;
    private String refDeviceId;
    private String tag;
    private String totalStorage;
    private String usedRam;
    private String usedStorage;
    private Boolean withinGeofence;
    private String locationFetchFailureReason;
    private String totalDataUsed;

    private static final long serialVersionUID = 8867821982507370629L;
    private String agent, agentMobile, deployState, modemSerial, modemModel;
    private int modemSignalLevel;
    private boolean camConnected, scannerConnected, rooted;
    private Long totalRegistration, totalSynchronized, totalConfirmed, dailyRegistration, dailySynchronized, dailyConfirmed;
    private String thresholdVersion, realTimeDeviceId, networkStrength, locationInformationSource;
    //determines if it is Wifi or Mobile Network
    private String networkConnectionType;
    private String livenessThresholdVersion;
    private Double locationAccuracy;
    //Determines if latitude and longitude is mocked
    private Boolean mockedCoordinate;
    private Boolean phoneStatusEnabled;
    private Boolean locationPermissionGranted;
    private String clientCurrentTime;
    private String hardDiskManufacturer;
    private String hardDiskSerialNumber;
    private String currentDeviceIdRetrievalStrategy;
    private String dataRoamingStatus, currentOperatorNetwork, homeOperatorNetwork;

    //time it took to make setting request and get a response
    private long pingLatency;

    //Exact Time response came in from the server
    private String responseTime;

    private Boolean displayTimeDialog;

    public List<AppDataUsageList> getAppDataUsageList() {
        return appDataUsageList;
    }

    public void setAppDataUsageList(List<AppDataUsageList> appDataUsageList) {
        this.appDataUsageList = appDataUsageList;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAvailableRam() {
        return availableRam;
    }

    public void setAvailableRam(String availableRam) {
        this.availableRam = availableRam;
    }

    public String getAvailableStorage() {
        return availableStorage;
    }

    public void setAvailableStorage(String availableStorage) {
        this.availableStorage = availableStorage;
    }

    public Boolean getBatteryChargeStatus() {
        return batteryChargeStatus;
    }

    public void setBatteryChargeStatus(Boolean batteryChargeStatus) {
        this.batteryChargeStatus = batteryChargeStatus;
    }

    public Double getClientUptime() {
        return clientUptime;
    }

    public void setClientUptime(Double clientUptime) {
        this.clientUptime = clientUptime;
    }

    public String getDeviceBatteryCharge() {
        return deviceBatteryCharge;
    }

    public void setDeviceBatteryCharge(String deviceBatteryCharge) {
        this.deviceBatteryCharge = deviceBatteryCharge;
    }

    public Boolean getKioskMode() {
        return kioskMode;
    }

    public void setKioskMode(Boolean kioskMode) {
        this.kioskMode = kioskMode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Boolean getLocalTimeCorrect() {
        return localTimeCorrect;
    }

    public void setLocalTimeCorrect(Boolean localTimeCorrect) {
        this.localTimeCorrect = localTimeCorrect;
    }

    public String getLocationGenerationTime() {
        return locationGenerationTime;
    }

    public void setLocationGenerationTime(String locationGenerationTime) {
        this.locationGenerationTime = locationGenerationTime;
    }

    public Double getLoginUptime() {
        return loginUptime;
    }

    public void setLoginUptime(Double loginUptime) {
        this.loginUptime = loginUptime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(String processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getRefDeviceId() {
        return refDeviceId;
    }

    public void setRefDeviceId(String refDeviceId) {
        this.refDeviceId = refDeviceId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTotalStorage() {
        return totalStorage;
    }

    public void setTotalStorage(String totalStorage) {
        this.totalStorage = totalStorage;
    }

    public String getUsedRam() {
        return usedRam;
    }

    public void setUsedRam(String usedRam) {
        this.usedRam = usedRam;
    }

    public String getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(String usedStorage) {
        this.usedStorage = usedStorage;
    }

    public Boolean getWithinGeofence() {
        return withinGeofence;
    }

    public void setWithinGeofence(Boolean withinGeofence) {
        this.withinGeofence = withinGeofence;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentMobile() {
        return agentMobile;
    }

    public void setAgentMobile(String agentMobile) {
        this.agentMobile = agentMobile;
    }

    public String getDeployState() {
        return deployState;
    }

    public void setDeployState(String deployState) {
        this.deployState = deployState;
    }

    public String getModemSerial() {
        return modemSerial;
    }

    public void setModemSerial(String modemSerial) {
        this.modemSerial = modemSerial;
    }

    public String getModemModel() {
        return modemModel;
    }

    public void setModemModel(String modemModel) {
        this.modemModel = modemModel;
    }

    public int getModemSignalLevel() {
        return modemSignalLevel;
    }

    public void setModemSignalLevel(int modemSignalLevel) {
        this.modemSignalLevel = modemSignalLevel;
    }

    public boolean isCamConnected() {
        return camConnected;
    }

    public void setCamConnected(boolean camConnected) {
        this.camConnected = camConnected;
    }

    public boolean isScannerConnected() {
        return scannerConnected;
    }

    public void setScannerConnected(boolean scannerConnected) {
        this.scannerConnected = scannerConnected;
    }

    public boolean isRooted() {
        return rooted;
    }

    public void setRooted(boolean rooted) {
        this.rooted = rooted;
    }

    public Long getTotalRegistration() {
        return totalRegistration;
    }

    public void setTotalRegistration(Long totalRegistration) {
        this.totalRegistration = totalRegistration;
    }

    public Long getTotalSynchronized() {
        return totalSynchronized;
    }

    public void setTotalSynchronized(Long totalSynchronized) {
        this.totalSynchronized = totalSynchronized;
    }

    public Long getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public Long getDailyRegistration() {
        return dailyRegistration;
    }

    public void setDailyRegistration(Long dailyRegistration) {
        this.dailyRegistration = dailyRegistration;
    }

    public Long getDailySynchronized() {
        return dailySynchronized;
    }

    public void setDailySynchronized(Long dailySynchronized) {
        this.dailySynchronized = dailySynchronized;
    }

    public Long getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(Long dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public String getThresholdVersion() {
        return thresholdVersion;
    }

    public void setThresholdVersion(String thresholdVersion) {
        this.thresholdVersion = thresholdVersion;
    }

    public String getRealTimeDeviceId() {
        return realTimeDeviceId;
    }

    public void setRealTimeDeviceId(String realTimeDeviceId) {
        this.realTimeDeviceId = realTimeDeviceId;
    }

    public String getNetworkStrength() {
        return networkStrength;
    }

    public void setNetworkStrength(String networkStrength) {
        this.networkStrength = networkStrength;
    }

    public String getLocationInformationSource() {
        return locationInformationSource;
    }

    public void setLocationInformationSource(String locationInformationSource) {
        this.locationInformationSource = locationInformationSource;
    }

    public String getNetworkConnectionType() {
        return networkConnectionType;
    }

    public void setNetworkConnectionType(String networkConnectionType) {
        this.networkConnectionType = networkConnectionType;
    }

    public String getLivenessThresholdVersion() {
        return livenessThresholdVersion;
    }

    public void setLivenessThresholdVersion(String livenessThresholdVersion) {
        this.livenessThresholdVersion = livenessThresholdVersion;
    }

    public Double getLocationAccuracy() {
        return locationAccuracy;
    }

    public void setLocationAccuracy(Double locationAccuracy) {
        this.locationAccuracy = locationAccuracy;
    }

    public Boolean getMockedCoordinate() {
        return mockedCoordinate;
    }

    public void setMockedCoordinate(Boolean mockedCoordinate) {
        this.mockedCoordinate = mockedCoordinate;
    }

    public Boolean getPhoneStatusEnabled() {
        return phoneStatusEnabled;
    }

    public void setPhoneStatusEnabled(Boolean phoneStatusEnabled) {
        this.phoneStatusEnabled = phoneStatusEnabled;
    }

    public Boolean getLocationPermissionGranted() {
        return locationPermissionGranted;
    }

    public void setLocationPermissionGranted(Boolean locationPermissionGranted) {
        this.locationPermissionGranted = locationPermissionGranted;
    }

    public String getClientCurrentTime() {
        return clientCurrentTime;
    }

    public void setClientCurrentTime(String clientCurrentTime) {
        this.clientCurrentTime = clientCurrentTime;
    }

    public String getHardDiskManufacturer() {
        return hardDiskManufacturer;
    }

    public void setHardDiskManufacturer(String hardDiskManufacturer) {
        this.hardDiskManufacturer = hardDiskManufacturer;
    }

    public String getHardDiskSerialNumber() {
        return hardDiskSerialNumber;
    }

    public void setHardDiskSerialNumber(String hardDiskSerialNumber) {
        this.hardDiskSerialNumber = hardDiskSerialNumber;
    }

    public String getCurrentDeviceIdRetrievalStrategy() {
        return currentDeviceIdRetrievalStrategy;
    }

    public void setCurrentDeviceIdRetrievalStrategy(String currentDeviceIdRetrievalStrategy) {
        this.currentDeviceIdRetrievalStrategy = currentDeviceIdRetrievalStrategy;
    }

    public long getPingLatency() {
        return pingLatency;
    }

    public void setPingLatency(long pingLatency) {
        this.pingLatency = pingLatency;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public Boolean getDisplayTimeDialog() {
        return displayTimeDialog;
    }

    public void setDisplayTimeDialog(Boolean displayTimeDialog) {
        this.displayTimeDialog = displayTimeDialog;
    }

    public String getDataRoamingStatus() {
        return dataRoamingStatus;
    }

    public void setDataRoamingStatus(String dataRoamingStatus) {
        this.dataRoamingStatus = dataRoamingStatus;
    }

    public String getCurrentOperatorNetwork() {
        return currentOperatorNetwork;
    }

    public void setCurrentOperatorNetwork(String currentOperatorNetwork) {
        this.currentOperatorNetwork = currentOperatorNetwork;
    }

    public String getHomeOperatorNetwork() {
        return homeOperatorNetwork;
    }

    public void setHomeOperatorNetwork(String homeOperatorNetwork) {
        this.homeOperatorNetwork = homeOperatorNetwork;
    }

    public String getLocationFetchFailureReason() {
        return locationFetchFailureReason;
    }

    public void setLocationFetchFailureReason(String locationFetchFailureReason) {
        this.locationFetchFailureReason = locationFetchFailureReason;
    }

    public String getTotalDataUsed() {
        return totalDataUsed;
    }

    public void setTotalDataUsed(String totalDataUsed) {
        this.totalDataUsed = totalDataUsed;
    }
}
