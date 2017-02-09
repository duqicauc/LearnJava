import org.apache.http.client.HttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    HttpClient httpClient;

    @Test
    public void httpClientAutoWired() throws Exception {
        Assert.assertNotNull(httpClient);
    }
}
