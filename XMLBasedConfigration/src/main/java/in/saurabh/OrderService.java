package in.saurabh;

import org.springframework.stereotype.Component;

public class OrderService {

    private  PaymentMode paymentService ;

    public  OrderService(PaymentMode paymentService){
        System.out.println("Order Created !! ");
        this.paymentService = paymentService;
    }

//
//    public void setPaymentServiceBean(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placed(){
        paymentService.pay();
//        System.out.println( "by using "+paymentService.type);
        System.out.println("order placed !! ");
    }
}
