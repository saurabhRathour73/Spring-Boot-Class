package in.saurabh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //  ConfigurableApplicationContext v ApplicationContext ko implement karti haii iske under close method hota haii
          ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

        AppConfig config = context.getBean(AppConfig.class);



            CartService cart = context.getBean(CartService.class);
            System.out.println(cart.getValue(20));
            context.close();




    }
}
