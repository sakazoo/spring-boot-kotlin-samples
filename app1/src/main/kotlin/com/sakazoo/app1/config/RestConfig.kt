package com.sakazoo.app1.config

import org.apache.http.client.config.RequestConfig
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class RestConfig {
    @Bean
    fun restTemplate(): RestTemplate = RestTemplate(httpRequestFactory())

    @Bean
    fun httpRequestFactory(): HttpComponentsClientHttpRequestFactory {
        val connectionManager = PoolingHttpClientConnectionManager()
        connectionManager.maxTotal = 10
        connectionManager.defaultMaxPerRoute = 10

        val config = RequestConfig.custom()
            .setSocketTimeout(3000)
            .setConnectTimeout(5000)
            .setConnectionRequestTimeout(5000)
            .build()

        val client = HttpClientBuilder.create()
            .setDefaultRequestConfig(config)
            .setConnectionManager(connectionManager).build()
        return HttpComponentsClientHttpRequestFactory(client)
    }
}