
package com.seamfix.appmonitor.heartbeat.model;

import java.util.List;

@SuppressWarnings("unused")
public class DeviceHeartBeatRequest {

    private String deviceId = "70f7174e44c12e6a";    // For devices >= SDK_VERSION 28 use the device id, devices
                                                        // running SDK_VERSION < 28 use the secure android id
    private String agentName = "";
    private String agentPhoneNumber = "";
    private String macAddress = "";
    private String cameraStatus = "";
    private String scannerStatus = "";
    private String clientTimeStatus = "";
    private Long clientUptime = Long.MIN_VALUE; // An indication of how long the client has been running
    private Long receiptDate = Long.MIN_VALUE;  // The timestamp the API received the payload from the service
    private Double longitude = Double.MIN_VALUE;
    private Double latitude = Double.MIN_VALUE;
    private Boolean rooted = true;
    private String osName = "";
    private String osVersion = "";
    private String locationInformationSource = "";  // locationInformationSource one of GPS or WIFI
    private String locationAccuracy = "";
    private String processorSpeed = "";
    private String usedStorage = "";
    private String availableStorage = "";
    private String totalStorage = "";
    private String ramSize = "";
    private String appVersion = "";
    private Boolean locationPermissionGranted = false;
    private Long locationGenerationTime = 0L;
    private String coordinateAddress = "";

    private String scannerModel = "";            // - To be added

     private String networkStrength;
     private String networkConnectionType;
     private String networkType;

    private List<AppDataUsageList> appDataUsageList;
    private String availableRam;
    private Boolean batteryChargeStatus;
    private String deviceBatteryCharge;
    private Boolean kioskMode;
    private Boolean localTimeCorrect;
    private Double loginUptime;
    private String networkName;
    private String processorType;
    private String tag;
    private String usedRam;
    private Boolean withinGeofence;
    private String locationFetchFailureReason;
    private String totalDataUsed;
    private static final long serialVersionUID = 8867821982507370629L;
    private String deployState, modemSerial, modemModel;
    private Integer modemSignalLevel;
    private Long totalRegistration, totalSynchronized, totalConfirmed, dailyRegistration, dailySynchronized, dailyConfirmed;
    private String thresholdVersion, realTimeDeviceId;
    //determines if it is Wifi or Mobile Network
    private String livenessThresholdVersion;
    //Determines if latitude and longitude is mocked
    private Boolean mockedCoordinate;
    private Boolean phoneStatusEnabled;
    private String clientCurrentTime;
    private String hardDiskManufacturer;
    private String hardDiskSerialNumber;
    private String currentDeviceIdRetrievalStrategy;
    private String dataRoamingStatus, currentOperatorNetwork, homeOperatorNetwork;
    //time it took to make setting request and get a response
    private Long pingLatency;
    //Exact Time response came in from the server
    private String responseTime;
    private Boolean displayTimeDialog;



    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * Fetches the time the HeartBeat was sent.
     * @return the time on the device
     * */
    public String getClientTimeStatus() {
        return clientTimeStatus;
    }

    /**
     * Sets the time the HeartBeat was sent.
     * @param clientTimeStatus current time on the device
     */
    public void setClientTimeStatus(String clientTimeStatus) {
        this.clientTimeStatus = clientTimeStatus;
    }

    public Long getClientUptime() {
        return clientUptime;
    }

    public void setClientUptime(Long clientUptime) {
        this.clientUptime = clientUptime;
    }

    public Long getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Long receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean isRooted() {
        return rooted;
    }

    public void setRooted(boolean rooted) {
        this.rooted = rooted;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(String usedStorage) {
        this.usedStorage = usedStorage;
    }

    public String getAvailableStorage() {
        return availableStorage;
    }

    public void setAvailableStorage(String availableStorage) {
        this.availableStorage = availableStorage;
    }

    public String getTotalStorage() {
        return totalStorage;
    }

    public void setTotalStorage(String totalStorage) {
        this.totalStorage = totalStorage;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Boolean getLocationPermissionGranted() {
        return locationPermissionGranted;
    }

    public void setLocationPermissionGranted(Boolean locationPermissionGranted) {
        this.locationPermissionGranted = locationPermissionGranted;
    }

    public Long getLocationGenerationTime() {
        return locationGenerationTime;
    }

    public void setLocationGenerationTime(Long locationGenerationTime) {
        this.locationGenerationTime = locationGenerationTime;
    }

    public String getCoordinateAddress() {
        return coordinateAddress;
    }

    public void setCoordinateAddress(String coordinateAddress) {
        this.coordinateAddress = coordinateAddress;
    }

    public String getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(String processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getLocationInformationSource() {
        return locationInformationSource;
    }

    public void setLocationInformationSource(String locationInformationSource) {
        this.locationInformationSource = locationInformationSource;
    }

    public String getLocationAccuracy() {
        return locationAccuracy;
    }

    public void setLocationAccuracy(String locationAccuracy) {
        this.locationAccuracy = locationAccuracy;
    }

//    public String getNetworkStrength() {
//        return networkStrength;
//    }
//
//    public void setNetworkStrength(String networkStrength) {
//        this.networkStrength = networkStrength;
//    }
//
//    public String getNetworkConnectionType() {
//        return networkConnectionType;
//    }
//
//    public void setNetworkConnectionType(String networkConnectionType) {
//        this.networkConnectionType = networkConnectionType;
//    }
//
//    public String getNetworkType() {
//        return networkType;
//    }
//
//    public void setNetworkType(String networkType) {
//        this.networkType = networkType;
//    }

    public String getCameraStatus() { return cameraStatus; }

    public void setCameraStatus(String cameraStatus) { this.cameraStatus = cameraStatus; }

    public String getScannerStatus() { return scannerStatus; }

    public void setScannerStatus(String scannerStatus) { this.scannerStatus = scannerStatus; }

    public String getAgentPhoneNumber() {
        return agentPhoneNumber;
    }

    public void setAgentPhoneNumber(String agentPhoneNumber) {
        this.agentPhoneNumber = agentPhoneNumber;
    }

    public String getScannerModel() {
        return scannerModel;
    }

    public void setScannerModel(String scannerModel) {
        this.scannerModel = scannerModel;
    }

    // ---------------------------------------------------------------------------------------------
    public List<AppDataUsageList> getAppDataUsageList() {
        return appDataUsageList;
    }

    public void setAppDataUsageList(List<AppDataUsageList> appDataUsageList) {
        this.appDataUsageList = appDataUsageList;
    }

    public String getAvailableRam() {
        return availableRam;
    }

    public void setAvailableRam(String availableRam) {
        this.availableRam = availableRam;
    }

    public Boolean getBatteryChargeStatus() {
        return batteryChargeStatus;
    }

    public void setBatteryChargeStatus(Boolean batteryChargeStatus) {
        this.batteryChargeStatus = batteryChargeStatus;
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

    public Boolean getLocalTimeCorrect() {
        return localTimeCorrect;
    }

    public void setLocalTimeCorrect(Boolean localTimeCorrect) {
        this.localTimeCorrect = localTimeCorrect;
    }

    public Double getLoginUptime() {
        return loginUptime;
    }

    public void setLoginUptime(Double loginUptime) {
        this.loginUptime = loginUptime;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUsedRam() {
        return usedRam;
    }

    public void setUsedRam(String usedRam) {
        this.usedRam = usedRam;
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

    public Integer getModemSignalLevel() {
        return modemSignalLevel;
    }

    public void setModemSignalLevel(int modemSignalLevel) {
        this.modemSignalLevel = modemSignalLevel;
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

    public String getLivenessThresholdVersion() {
        return livenessThresholdVersion;
    }

    public void setLivenessThresholdVersion(String livenessThresholdVersion) {
        this.livenessThresholdVersion = livenessThresholdVersion;
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

    public Long getPingLatency() {
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
