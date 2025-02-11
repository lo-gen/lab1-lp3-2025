import java.awt.*;

public class CarTransport extends Car{

    private int totalSpace;
    private boolean Ramp;


    public CarTransport(){
        super(2, 50, Color.black, "Car Transport");
        stopEngine();
    }


    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }


    public boolean RampUp(){
        if (getCurrentSpeed() != 0){
            return Ramp = true;
        }
        else{
            return Ramp = false;
        }
    }


    public boolean RampDown(){
        if (getCurrentSpeed() != 0){
            return Ramp = false;
        }
        else{
            return Ramp = true;
        }
    }


    public String RampStatus(){
        if (Ramp == false){
            return  "Ramp is up";
        }
        else{
            return "Ramp is down";
        }
    }


    public void addObject(Car randomcar){
        if (Ramp == false){
        }
        else{
            store randomcar on CarTransport;
        }
    }


    public void removeObject(Car randomcar){
        if (Ramp == false){
        }
        else{
            remove randomcar from CarTransport;
        }
    }

}