import java.awt.*;

public class Scania extends Car implements ITruckBed, ITruck {

    private int rampAngle = 0;

    public Scania(){
        super(2, 770, Color.BLUE, "Scania");
        stopEngine();
    }

    public int getRampAngle(){
        return rampAngle;
    }

    protected void setRampAngle(int rampAngle){
        this.rampAngle = rampAngle;
    }

    @Override
    public void rampDown(int amount) {
        if (rampAngle - amount > 0)
            rampAngle -= amount;
        else
            rampAngle = 0;
    }

    @Override
    public void rampUp(int amount){
        if (getCurrentSpeed() != 0)
            return;
        if (rampAngle + amount < 70)
            rampAngle += amount;
        else
            rampAngle = 70;

    }

    @Override public double speedFactor(){
        return getEnginePower() * 0.001;
    }

    @Override
    public void gas(double amount){
        if (rampAngle == 0)
            super.gas(amount);
    }
}