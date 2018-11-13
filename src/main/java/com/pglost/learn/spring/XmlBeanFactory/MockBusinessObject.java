package com.pglost.learn.spring.XmlBeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockBusinessObject {
    private String dependency1;
    private int dependency2;
    public MockBusinessObject(){
    }
    public MockBusinessObject(String dependency){
        this.dependency1 = dependency;
    }
    public MockBusinessObject(int dependency) {
        this.dependency2 = dependency;
    }
    public MockBusinessObject(String dependency1, int dependency2) {
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public void setDependency1(String dependency1) {
        this.dependency1 = dependency1;
    }

    public void setDependency2(int dependency2) {
        this.dependency2 = dependency2;
    }

    @Override
    public String toString(){
      return new StringBuilder(super.toString()).append("dependency1="+dependency1).append("dependency2="+dependency2).toString();
    }

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("4-14-setter.xml");
        MockBusinessObject bean = ctx.getBean("MockB0",MockBusinessObject.class);
        System.out.println(bean.toString());
    }
}
