package tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * servlet配置相当于servlet.xml
 * @author Yien
 *2018年12月15日
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();
    static {
        servletMappingList.add(new ServletMapping("helloWorld","/helloworld","com.tomcat.HelloWorldServlet"));
    }

}
