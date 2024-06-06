package com.system.systemerp.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joyce
 */
@Configuration
public class SwaggerConfig implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * 啟動時在Console打印UI路徑
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Swagger UI: http://localhost:8082/swagger-ui/index.html");
    }
}
