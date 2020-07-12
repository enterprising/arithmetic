package net.tanpeng.httpclient;

import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: peng.tan
 * @create: 2020/07/12 02:43
 */
public class AsyncRequestTest {


    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        AsyncHttpClient c = new DefaultAsyncHttpClient();
        Future<Response> f = c.prepareGet(url).execute(new AsyncCompletionHandler<Response>() {

            // onCompleted method will be invoked once the http response has been fully read.
            //一旦完全读取Http响应，就调用onCompleted方法
            //Response object includes the http headers and the response body.
            //Response 对象包括HTTP请求头和响应体
            @Override
            public Response onCompleted(Response response) throws Exception {
                System.out.println("完成请求");
                return response;
            }

            @Override
            public void onThrowable(Throwable t) {
                System.out.println("出现异常");
                super.onThrowable(t);
            }
        });

        try {
            Response response = f.get();
            System.out.println(response.getResponseBody());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
