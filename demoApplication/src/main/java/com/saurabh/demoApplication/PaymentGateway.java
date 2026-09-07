package com.saurabh.demoApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

//    public PaymentGateway(
//            @Value("${paymentGateway.type}") String type,
//            @Value("${paymentGateway.count}") int count
//    ) {
//        this.type = type;
//        this.count = count;
//    }

    private PaymentProperty paymentProperty;
    public PaymentGateway(PaymentProperty paymentProperty){
        this.paymentProperty = paymentProperty;

    }

    public String getType() {
        return paymentProperty.getType();
    }
    public int  getRetryCount() {
        return paymentProperty.getRetryCount();
    }
    public Boolean isEnabled() {
        return paymentProperty.isEnabled();
    }

    public int getTimeout() {
        return paymentProperty.getTimeout();
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(isEnabled());
        System.out.println(getTimeout());
    }


    //    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//   @Value("${paymentGateway.type:Razorpay}") private  String type;
//    @Value("${paymentGateway.count:10}") private int count;
}


// @Value
