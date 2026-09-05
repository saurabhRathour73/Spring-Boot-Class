package in.saurabh.CarService;

public class Car {
    private  Engine engine;
    public  Car(Engine engine){
        this.engine = engine;
    }

    public void runCar(){
        engine.StartEngnine();
        System.out.println("Car on Runing mode !! ");
    }
}
