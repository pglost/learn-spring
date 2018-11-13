package com.pglost.learn.spring.BeanFactory;

import com.pglost.learn.spring.FXNewsProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryAnnotation {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-autowired.xml");
        FXNewsProvider newsProvider = ctx.getBean("FXNewsProvider", FXNewsProvider.class);
        newsProvider.getAndPersistNews();
    }

}
