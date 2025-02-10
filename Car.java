import java.awt.*;

public class Car extends Vehicle implements IVehicle {

    

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        
    }

    @Override
    public double speedFactor(){
        return 0;
    }

    public static void main(String[] args) {
        Car Car1 = new Car(4, 20, Color.black, "Hello");
        int hello = Car1.getNrDoors();
        System.out.println(hello);
    }
    

    

}