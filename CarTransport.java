import java.awt.*;

public class CarTransport<carType extends Car> extends Car{
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

    protected  void addCar(carType car){
        if (getSpaceLeft() > 0 && !rampUp)
            storage.addItem(car);
    }

    protected void removeCar(){
        if (!rampUp)
            storage.removeLastItem();
    }
}

