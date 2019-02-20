package tomcat;

/**
 *
 * Servlet 请求处理类
 * @author Yien
 *2018年12月15日
 */
public abstract class Servlet {
    //Tomcat是满足Servlet规范的容器,所以提供了doget,dopost,service等常用的方法
    public abstract  void doGet(MyRequest myRequest , MyResponse myResponse);
    public abstract  void doPost(MyRequest myRequest , MyResponse myResponse);
    public void service(MyRequest myRequest , MyResponse myResponse){
        if (myRequest.getMethod().equalsIgnoreCase("POST")){
            doPost(myRequest,myResponse);
        }else  if (myRequest.getMethod().equalsIgnoreCase("GET")){
            doGet(myRequest,myResponse);
        }

    }
}
