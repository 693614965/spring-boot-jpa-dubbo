package com.gaofeng.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * app
 */
@SpringBootApplication
@PropertySource({"classpath:dubbo.properties"})
@ImportResource({"classpath:applicationContext.xml"})
@ServletComponentScan(basePackages = "com.gaofeng.demo")
public class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }

}
