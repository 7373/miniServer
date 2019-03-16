package miniServer.servlet;

import miniServer.pojo.MyRequest;
import miniServer.pojo.MyResponse;

import java.io.IOException;

/**
 * 测试的servlet：DemoHelloWorldServlet.java
 * @author Yien
 * 2018年12月15日
 */
public class DemoHelloWorldServlet extends AbstractServlet {

    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("恭喜servlet访问成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("恭喜servlet访问成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

