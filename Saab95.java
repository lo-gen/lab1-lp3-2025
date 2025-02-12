import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;
        stopEngine();
    }

    public boolean getTurboOn(){
        return turboOn;
    }

    protected void setTurboOn(){
	    turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }
    
    @Override public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public static void main(String[] args) {
        Saab95 Car1 = new Saab95();  // Object 1
        System.out.println("Gas not applied: " + Car1.getCurrentSpeed()); // Print the result
        Car1.gas(10); // Call gas method and store the result
        System.out.println("Gas applied: " + Car1.getCurrentSpeed()); // Print the result

        // Test turbo functionality
        Car1.setTurboOn();
        System.out.println("Speed factor with turbo on: " + Car1.speedFactor());


        Car1.setTurboOff();
        System.out.println("Speed factor with turbo off: " + Car1.speedFactor());
    }
}