package net.tanpeng.spider;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 写个简单的爬虫
 * Created by peng.tan on 2018/10/24.
 */
public class SpiderTest {

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.custom().build();
        HttpGet get = new HttpGet("http://xxxx");
        HttpEntity entity = null;
        try (CloseableHttpResponse response = (CloseableHttpResponse) httpClient.execute(get)) {
            entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EntityUtils.consume(entity);
        }
    }

}
