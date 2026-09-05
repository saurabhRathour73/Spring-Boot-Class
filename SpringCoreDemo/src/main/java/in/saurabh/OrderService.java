package in.saurabh;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
//   private  PaymentService paymentService;

//   OrderService(PaymentService paymentService){
//       this.paymentService = paymentService;
//   }
    public void placeOrder(){
        System.out.println("Order Placed !! ");
//        paymentService.pay();
    }
}
