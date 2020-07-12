package net.tanpeng.httpclient;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * https://www.cnblogs.com/fonxian/p/10902172.html
 *
 * 同步 http
 * @author: peng.tan
 * @create: 2020/07/12 02:26
 */
public class SynRequestTest {
    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        AsyncHttpClient c = new DefaultAsyncHttpClient();
        Future<Response> f = c.prepareGet(url).execute();
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}