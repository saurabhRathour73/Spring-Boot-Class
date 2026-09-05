package in.saurabh;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.awt.event.AWTEventListener;
import java.util.HashMap;
import java.util.Map;

@Component
//public class CartService implements InitializingBean {
public class CartService implements BeanNameAware, ApplicationContextAware, DisposableBean {
    Map<Integer, String> mp;
    public CartService(){
        mp = new HashMap<>();
        System.out.println("CartService Constructor called !! ");
    }
    @PostConstruct
    public void start(){
        System.out.println("Initilization callback start using init method");
       mp.put(21,"saurabh");
       mp.put(20,"vanshika");
    }
//    @Override
//    public void afterPropertiesSet() throws Exception{
//        System.out.println("initilization callback ");
//        mp.put(21,"saurabh");
//        mp.put(20,"vanshika");
//    }
    public void addToCart(){
        System.out.println("Added to Cart");
    }

    public String getValue(int key){
       return mp.get(key);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is  : "+ name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext name is "+ applicationContext.getClass());
    }

    @Override
    public void destroy() throws Exception {
        mp.clear();
        System.out.println("bean is getting distroy");
    }
}
