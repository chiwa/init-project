package com.zengcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//NOSONAR came from springboot
public class Application { //NOSONAR came from springboot
    /*
     * Requires the following arguments to start:
     *  -Dspring.config.location=../main-app/src/main/resources/etc/application.yml
     *  -Dlogging.config=../main-app/src/main/resources/log/logback.xml
     */
    public static void main(String[] args) throws Exception {  //NOSONAR came from springboot
        SpringApplication.run(Application.class, args);//NOSONAR came from springboot
    }
}
