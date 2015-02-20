package com.gafful;

//import org.apache.catalina.core.ApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = SpringApplication.run(App.class, args);
        System.out.println( "Hello World! 0:-]" );

    }
}
