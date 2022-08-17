package com.ydlclass;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Arrays;

public class SocketTest {

    @Test
    public void inetAddressTest() throws UnknownHostException {
        InetAddress address = InetAddress.getLoopbackAddress();
        System.out.println(address);
        InetAddress[] baidu = InetAddress.getAllByName("www.baidu.com");
        System.out.println(Arrays.toString(baidu));
        InetAddress[] localhosts = InetAddress.getAllByName("localhost");
        System.out.println(Arrays.toString(localhosts));
        byte[] bytes = {127,0,0,1};
        InetAddress byAddress = InetAddress.getByAddress(bytes);
        System.out.println(Arrays.toString(bytes));
    }
    @Test
    public void urlTest() throws IOException {
        URL url = new URL("https://www.baidu.com/s?wd=%E7%9F%A5%E4%B9%8E&rsv_spt=1&rsv_iqid=0x802c4a81001001e8&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_dl=tb&rsv_enter=1&rsv_sug3=6&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&prefixsug=%25E7%259F%25A5%25E4%25B9%258E&rsp=5&inputT=1192&rsv_sug4=1192");
        System.out.println("url.getProtocol() = " + url.getProtocol());
        System.out.println("url.getHost() = " + url.getHost());
        System.out.println("url.getPath() = " + url.getPath());
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        OutputStream outputStream = new FileOutputStream("D:\\ddd.html");
        byte[] buffer = new byte[1024 * 1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }
    }

    @Test
    public void serverTest() throws IOException {
        // 创建ServerSocket
        ServerSocket server = new ServerSocket();
        // 绑定在某一个端口上
        server.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(),8888));
    }
}
