package com.seamfix.appmonitor.common

class ConfigBuilder {

    var baseURL: String = ""
    var headers: MutableList<Pair<String, String>> = mutableListOf()
    var endPoints: StringBuilder = java.lang.StringBuilder()

    fun build(): Config{
        return Config(this.baseURL, this.headers, endPoints.toString())
    }

    fun setBaseURL(url: String): ConfigBuilder{
        this.baseURL = url
        return this
    }

    fun addEndPoints(vararg paths: String): ConfigBuilder {
        for ((index, element) in paths.withIndex()) {
            if (index > 0) endPoints.append("/")
            endPoints.append(element)
        }
        return this
    }

    fun addHeader(header: Pair<String, String>): ConfigBuilder{
        this.headers.add(header)
        return this
    }

}