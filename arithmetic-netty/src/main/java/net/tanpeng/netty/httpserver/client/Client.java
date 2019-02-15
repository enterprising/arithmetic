package net.tanpeng.netty.httpserver.client;

/**
 * Created by peng.tan on 2019/2/15.
 */
public class Client {
    public static void main(String args[]) throws Exception {
        new Client().test();
    }

    //@Test
    public void test() throws Exception {
        HttpClient c = new HttpClient("http://localhost:3000");
        c.connect();
        String init = "{\"config\":{\"a\"=1}";
        byte[] res = c.send(init, "init");
        Thread.sleep(500);
//        System.out.println(new String(res));
    }
}
