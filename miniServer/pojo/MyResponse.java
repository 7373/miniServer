package miniServer.pojo;
import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 封装响应对象
 * 基于HTTP协议的格式进行输出写入
 * @author Yien
 *2018年12月15日
 */
@Data
public class MyResponse {
    private OutputStream outputStream;
    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    public  void  write(String content) throws IOException {
        /**
         * Http相应报文
         * @when
         */
        StringBuffer httpResponse  = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n").append("Content-Type:text/html\n")
                .append("\r\n").append("<html><body>").append(new StringBuffer(content))
                .append("</body><html>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }
}
