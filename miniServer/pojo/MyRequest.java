package miniServer.pojo;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

/**
 * 封装请求对象
 *通过输入流，对 HTTP 协议进行解析，
 *拿到了 HTTP 请求头的方法以及 URL。
 * @author Yien
 *2018年12月15日
 */
@Data
public class MyRequest {
    private  String url;
    private  String method;
    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if (0<(length = inputStream.read(httpRequestBytes))){
            httpRequest = new String(httpRequestBytes , 0 ,length);
        }
        //http 请求报文
        System.out.println("HTTP请求报文:\n"+httpRequest);
        //通过字符串截取URL和请求方法
        String httpHead = httpRequest.split("\n")[0];
        method = httpHead.split("\\s")[0];
        url = httpHead.split("\\s")[1];

        System.out.println(this);
    }

    public String toString() {
        return "MyRequest [url=" + url + ", method=" + method + "]";
    }
}
