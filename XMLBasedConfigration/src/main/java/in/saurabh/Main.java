package in.saurabh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // get bean by type
        // ek se jada bean hone se e work nhi karta haii
//        OrderService orderService = context.getBean(OrderService.class);

        // get bean by id/name
//        OrderService orderService =(OrderService) context.getBean("orderService") ;
//        OrderService orderService =context.getBean("orderService",OrderService.class);
//        orderService.placed();

        UserService userService = context.getBean(UserService.class);
        context.close();


    }
}
