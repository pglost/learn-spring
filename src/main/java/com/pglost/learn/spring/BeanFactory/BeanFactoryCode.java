package com.pglost.learn.spring.BeanFactory;

import com.pglost.learn.spring.FXNewsProvider;
import com.pglost.learn.spring.impl.DowJonesNewsListener;
import com.pglost.learn.spring.impl.DowJonesNewsPersister;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class BeanFactoryCode {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }
    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class, AbstractBeanDefinition.AUTOWIRE_NO, false);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class, AbstractBeanDefinition.AUTOWIRE_NO, true);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class, AbstractBeanDefinition.AUTOWIRE_NO, true);
        //将Bean定义注入到容器中
        registry.registerBeanDefinition("djNewsProvider", newsProvider);
        registry.registerBeanDefinition("djNewsListener", newsListener);
        registry.registerBeanDefinition("djnewsPersister", newsPersister);
        //构造方式注入
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, newsListener);
        argValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);
        //get方式注入
        /**
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersister", newsPersister));
        newsProvider.setPropertyValues(propertyValues);
        */
        //绑定完成
        return (BeanFactory)registry;

    }
}
