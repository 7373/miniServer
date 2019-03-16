package miniServer.config;

import miniServer.pojo.ServletMapping;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * servlet配置相当于servlet.xml
 * @author Yien
 * 2018年12月15日
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new CopyOnWriteArrayList<>();

    /**
     * 初始化servlet容器
     * @when
     */
    static {
        servletMappingList.add(new ServletMapping("helloWorld","/helloworld","miniServer.servlet.DemoHelloWorldServlet"));
    }

}
