package org.java.learn.httpclient;

import org.apache.commons.codec.Charsets;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.FactoryBean;

import java.net.SocketTimeoutException;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2017/2/9
 * Time: 13:54
 */
public class HttpClientFactoryBean implements FactoryBean<HttpClient> {

    private static final int DEFAULT_MAX_TOTAL = 512;
    private static final int DEFAULT_MAX_PER_ROUTE = 64;
    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    private static final int DEFAULT_SOCKET_TIMEOUT = 3000;

    @Override
    public HttpClient getObject() throws Exception {
        ConnectionConfig config = ConnectionConfig.custom()
            .setCharset(Charsets.UTF_8)
            .build();

        RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT)
            .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT)
            .build();

        return HttpClients.custom()
            .setMaxConnPerRoute(DEFAULT_MAX_PER_ROUTE)
            .setMaxConnTotal(DEFAULT_MAX_TOTAL)
            .setRetryHandler((exception, executionCount, context) -> executionCount <= 3 && (exception instanceof NoHttpResponseException
                                                                                         || exception instanceof ClientProtocolException
                                                                                         || exception instanceof SocketTimeoutException
                                                                                         || exception instanceof ConnectTimeoutException))
            .setDefaultConnectionConfig(config)
            .setDefaultRequestConfig(defaultRequestConfig)
            .build();
    }

    @Override
    public Class<?> getObjectType() {
        return HttpClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
