package com.arun.didemo.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public LifeCycleDemoBean() {
        System.out.println("## 1. Constructor called ");
        System.out.println();
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("## 2. Bean Name is " + s);
        System.out.println();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## 3. Bean factory aware called");
        System.out.println();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## 4. Application context called");
        System.out.println();
    }

    public void beforeInit() {
        System.out.println("## 5. Before Init called by Bean Post Processor");
        System.out.println();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## 6. Post construct method called");
        System.out.println();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## 7. Life cycle bean has its properties set");
        System.out.println();
    }

    public void afterInit() {
        System.out.println("## 8. After Init called by Bean Post Processor");
        System.out.println();
    }

    //after this the bean is ready to use

    @PreDestroy
    public void preDestroy() {
        System.out.println("## 9. Pre destroy method called");
        System.out.println();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## 10. Destroy method called");
        System.out.println();
    }
}
