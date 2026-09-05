package in.saurabh;

import in.saurabh.CarService.Car;
import in.saurabh.CarService.Engine;
import in.saurabh.OrderService.OrderService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        System.out.println("hlw i started today lacture ");

//        OrderService order = new OrderService();
//        order.placeOrder();

        Engine engine = new Engine();
        Car car = new Car(engine);
        car.runCar();


    }
}
