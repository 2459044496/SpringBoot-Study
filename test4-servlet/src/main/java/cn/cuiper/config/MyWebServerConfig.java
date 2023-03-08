/*
package cn.cuiper.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyWebServerConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    */
/**
     * 定制或修改tomcat配置
     * 1，修改yml或properties文件
     * 2，实现接口WebServerFactoryCustomizer<ConfigurableWebServerFactory>，重写customize方法
     * *//*


    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        //使用对应工厂类提供给我们的接口定制化我们的tomcat connector
        ((TomcatServletWebServerFactory) factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
                //定制KeepAliveTimeout，设置30秒内没有请求则服务器自动断开keepalive连接
                protocol.setKeepAliveTimeout(30000);
                //当客户端发送超过10000个请求则自动断开keepalive连接
                protocol.setMaxKeepAliveRequests(10000);
                protocol.setPort(7777);
            }
        });
    }
}
*/
