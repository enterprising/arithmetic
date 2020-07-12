package net.tanpeng.httpclient;

import org.apache.http.HttpHost;
import org.asynchttpclient.*;
import org.asynchttpclient.proxy.ProxyServer;
import org.asynchttpclient.proxy.ProxyServerSelector;
import org.asynchttpclient.uri.Uri;

import static org.asynchttpclient.Dsl.asyncHttpClient;

/**
 * @author: peng.tan
 * @create: 2020/07/12 02:45
 */
public class ConfigTest {
    private AsyncHttpClient client = asyncHttpClient(
            new DefaultAsyncHttpClientConfig.Builder()
                    .setFollowRedirect(true)
                    .setProxyServerSelector(new ProxySelector())
                    .setIoThreadsCount(Runtime.getRuntime().availableProcessors() * 2)
                    .setConnectTimeout(1000)
                    .setReadTimeout(1000)
                    .setRequestTimeout(3000)
                    .setMaxRequestRetry(2)
                    .setThreadPoolName("ASYNC-CLIENT")
    );


    private class ProxySelector implements ProxyServerSelector {

        @Override
        public ProxyServer select(Uri uri) {
            //从代理池中获取HttpHost
//            final HttpHost proxy = getProxy(uri.getHost());
            final HttpHost proxy = new HttpHost("baidu.com", 80);
            if (proxy == null) {
                return null;
            }
            final ProxyServer.Builder builder = new ProxyServer.Builder(proxy.getHostName(), proxy.getPort());
            return builder.build();
        }
    }

    public static void main(String[] args) {

    }
}
