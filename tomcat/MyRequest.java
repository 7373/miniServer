package tomcat;
import java.io.IOException;
import java.io.InputStream;

/**
 * 封装请求对象
 *通过输入流，对 HTTP 协议进行解析，
 *拿到了 HTTP 请求头的方法以及 URL。
 * @author Yien
 *2018年12月15日
 */
public class MyRequest {
    private String url;
    private  String method;
    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes))>0){
            httpRequest = new String(httpRequestBytes , 0 ,length);
        }
        //http 请求协议
        //System.out.println(httpRequest);
        //通过字符串截取URL和请求方法
        String httpHead = httpRequest.split("\n")[0];
        method = httpHead.split("\\s")[0];
        url = httpHead.split("\\s")[1];

        System.out.println(this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String toString() {
        return "MyRequest [url=" + url + ", method=" + method + "]";
    }
}
