import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Semaphore;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: duqi
 * Date: 2017/2/9
 * Time: 14:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HttpClientFactoryBeanXmlTest {

    @Resource
    private CloseableHttpClient httpClient;

    @Resource
    private CloseableHttpAsyncClient asyncClient;

    @Test
    public void httpClientAutoWired() throws Exception {
        Assert.assertNotNull(httpClient);
    }

    private static final Semaphore concurrency = new Semaphore(1024);
    @Test
    public void asyncClientTest() throws Exception {
        Assert.assertNotNull(asyncClient);

        //step1 获取信号量控制并发数（防止内存溢出）
        concurrency.acquireUninterruptibly();

        try {
            //step2 设置HttpUrlRequest
            final HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri("http://www.baidu.com")
                .build();

            //step3 执行异步调用
            asyncClient.execute(httpUriRequest, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse httpResponse) {
                    //处理Http响应
                }

                @Override
                public void failed(Exception e) {
                    //根据情况进行重试
                }

                @Override
                public void cancelled() {
                    //记录失败日志
                }
            });
        } finally {
            //step4 释放信号量
            concurrency.release();
        }
    }
}
