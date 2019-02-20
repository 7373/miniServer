package tomcat;

import java.io.IOException;

/**
 * 测试的servlet：helloworldservlet.java
 * @author Yien
 *2018年12月15日
 */
public class HelloWorldServlet extends Servlet {

    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("hello word");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("hello word");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

