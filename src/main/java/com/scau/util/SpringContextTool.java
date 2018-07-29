package com.scau.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextAware接口来让Spring在启动的时候为我们注入ApplicationContext对象
 * 调用其getBean("beanName")方法来得到由Spring 管理所有对象
 */
public class SpringContextTool implements ApplicationContextAware {

    private static ApplicationContext context = null;

    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
    public static <T> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }

    public static ApplicationContext getContext(){
        return context;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.initApplicationContext(applicationContext);
    }

    private void initApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }
}
