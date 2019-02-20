package tomcat;

import java.io.IOException;
/**
 *请求链接错误的servlet：ClassNotFoundServlet.java

 * @author Yien 2019/2/18 14:56
 */
public class ClassNotFoundServlet extends Servlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("<h1 style='color:red'>can not found this servlet<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("<h1 style='color:red'>can not found this servlet<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
