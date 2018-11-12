package com.pglost.learn.spring.BeanFactory;

import com.pglost.learn.spring.FXNewsProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.*;

public class BeanFactoryProp {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaPropertiesFile(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }
    public static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry){
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:binding-config.properties");
        return (BeanFactory)registry;
    }
}
