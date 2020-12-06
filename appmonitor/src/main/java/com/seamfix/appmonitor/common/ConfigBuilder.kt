package com.seamfix.appmonitor.common

class ConfigBuilder {

    var baseURL: String = ""
    var headers: MutableList<Pair<String, String>> = mutableListOf()

    fun build(): Config{
        return Config(this.baseURL, this.headers)
    }

    fun setBaseURL(url: String): ConfigBuilder{
        this.baseURL = url
        return this
    }

    fun addHeader(header: Pair<String, String>): ConfigBuilder{
        this.headers.add(header)
        return this
    }

}