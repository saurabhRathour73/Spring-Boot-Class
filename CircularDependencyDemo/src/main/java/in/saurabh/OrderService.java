package in.saurabh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private  PaymentService paymentService ;

//    public OrderService(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }

    public void  placeOrder(){
        paymentService.pay();
        getOrderDetails();
        System.out.println("Order Placed Successfully !! ");
    }

    public void getOrderDetails(){
        System.out.println("This is your Order details !! ");
    }


}
