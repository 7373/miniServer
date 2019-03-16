package miniServer;

import miniServer.config.ServletMappingConfig;
import miniServer.pojo.MyRequest;
import miniServer.pojo.MyResponse;
import miniServer.pojo.ServletMapping;
import miniServer.servlet.AbstractServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 启动类
 * Tomcat 是一个的 Web Server，它也是一个满足 Servlet 规范的容器。我们想要在浏览器上运行自己的项目，那么就必须把web项目放到服务器中运行，而tomcat正是一个很好的webserver。
 * Java实现tomcat的功能的思路：tomcat的启动是基于socket服务，它支持 HTTP 协议！，将请求和响应封装成request和response。利用反射实例化具体的 Servlet 中，用io流将内容输出到浏览器
 * ---------------------
 *
 * @author Yien
 * 2018年12月15日
 */
 /*Tomcat 的处理流程
  把 URL 对应处理的 Servlet 关系形成，
  解析 HTTP 协议，封装请求/响应对象，
  利用反射实例化具体的 Servlet 进行处理即可。*/
public class MiniServer {
    private static int port = 8088;
    /**
     * key-url value-class
     *
     * @when
     */
    private Map<String, String> urlServletMap = new ConcurrentHashMap<>();


    public void init() {
        initServletMapping();
        ServerSocket serverSocket = null;
        try {
            /**
             * 这里考虑 reactor 或者 proactor实现模式
             * @when 2019年3月14日
             */
            serverSocket = new ServerSocket(port);
            System.out.println("MiniServer is start....");
            while (true) {
                Socket socket = serverSocket.accept();
                // 解析 HTTP 协议，封装请求/响应对象
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);
                dispatch(myRequest, myResponse);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
        String clazz = urlServletMap.get(myRequest.getUrl());
        if (clazz == null) {
            System.out.println("clazz =null");
            clazz = "miniServer.servlet.ClassNotFoundServlet";
        }
        //反射
        try {
            Class<AbstractServlet> myServletClass = (Class<AbstractServlet>) Class.forName(clazz);
            AbstractServlet myAbstractServlet = myServletClass.getDeclaredConstructor().newInstance();
            myAbstractServlet.service(myRequest, myResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化Map
     * @when
     */
    private void initServletMapping() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    public static void main(String[] args) {
        new MiniServer().init();
    }
}
