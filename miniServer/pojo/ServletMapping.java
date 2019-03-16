package miniServer.pojo;


import lombok.Data;

/**
 * Servlet 配置
 * @author Yien
 *2018年12月15日
 */
@Data
public final class ServletMapping {
    private String servletName;
    private String url;
    private String clazz;

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }
}
