package org.java.learn.httpclient;

import org.apache.commons.codec.Charsets;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.FactoryBean;

import java.net.SocketTimeoutException;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2017/2/9
 * Time: 13:54
 */
public class HttpClientFactoryBean implements FactoryBean<CloseableHttpClient> {

    // 知识点1：路由(MAX_PER_ROUTE)是对最大连接数（MAX_TOTAL）的细分，整个连接池的限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
    // 设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，
    private static final int DEFAULT_MAX_TOTAL = 512; //最大支持的连接数
    private static final int DEFAULT_MAX_PER_ROUTE = 64; //针对某个域名的最大连接数

    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000; //知识点2：跟目标服务建立连接超时时间，根据自己的业务调整
    private static final int DEFAULT_SOCKET_TIMEOUT = 3000; //知识点3：请求的超时时间（建联后，获取response的返回等待时间）
    private static final int DEFAULT_TIMEOUT = 1000; //知识点4：从连接池中获取连接的超时时间

    @Override
    public CloseableHttpClient getObject() throws Exception {
        ConnectionConfig config = ConnectionConfig.custom()
            .setCharset(Charsets.UTF_8)
            .build();

        RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT)
            .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT)
            .setConnectionRequestTimeout(DEFAULT_TIMEOUT)
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
        return CloseableHttpClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
