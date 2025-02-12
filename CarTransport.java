import java.awt.*;

public class CarTransport<carType extends IPassagerCar> extends Car implements ITruck{
    private StorageUnit<carType> storage;
    private boolean rampUp;

    public CarTransport(int totalSpace){
        super(2, 500, Color.RED, "CarTransport");
        storage = new StorageUnit<>(totalSpace);
        rampUp = false;
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.001;
    }

    protected void rampUp(){
        rampUp = true;
    }

    protected void rampDown(){
        if (getCurrentSpeed() == 0)
            rampUp = false;
    }

    public boolean getRampUpStatus(){
        return rampUp;
    }

    protected int getSpaceUsed(){
        return storage.getSpaceUsed();
    }

    protected int getSpaceLeft(){
        return storage.getSpaceLeft();
    }

    private double distanceBetween(carType car){
        return Math.sqrt(Math.pow(car.getXPos() - getXPos(), 2) + Math.pow(car.getYPos() - getYPos(), 2));
    }

    protected void addCar(carType car){
        if (getSpaceLeft() > 0 && !rampUp && distanceBetween(car) < 6.9){
            storage.addItem(car);
            car.setXYPos(getXPos(), getYPos());
        }
    }

    protected void removeCar(){
        if (!rampUp) {
            storage.getItems().get(storage.getSpaceUsed() - 1).setXYPos(getXPos() + 2, getYPos());
            storage.removeLastItem();
        }
    }

    @Override
    public void gas(double amount){
        if (rampUp)
            super.gas(amount);
    }

    @Override
    public void move(){
        super.move();
        for (carType car : storage.getItems()){
            car.setXYPos(getXPos(), getYPos());
        }
    }
}

