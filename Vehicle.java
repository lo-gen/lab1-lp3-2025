import java.awt.*;

public abstract class Vehicle implements IVehicle  {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xPos;
    private double yPos;
    private double positionAngle;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    @Override
    public int getNrDoors(){
        return nrDoors;
    }

    @Override
    public void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }

    @Override
    public double getEnginePower(){
        return enginePower;
    }

    @Override
    public void setEnginePower(double enginePower){
        this.enginePower = enginePower;
    }

    @Override
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    @Override
    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = Math.min(enginePower, currentSpeed);
    }

    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public void setColor(Color color){
        this.color = color;
    }

    @Override
    public String getModelName(){
        return modelName;
    }

    @Override
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void startEngine(){
        currentSpeed = 0.1;
    }

    @Override
    public void stopEngine(){
        currentSpeed = 0;
    }

    @Override
    public abstract double speedFactor();

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    @Override
    public void gas(double amount){
        amount = Math.min(1, Math.max(0, amount));  //Math.clamp(0, 1, amount)
        incrementSpeed(amount);
    }

    @Override
    public void brake(double amount){
        amount = Math.min(1, Math.max(0, amount));
        decrementSpeed(amount);
    }

    @Override
    public void setX(double xPos){
        this.xPos = xPos;
    }

    @Override
    public void setY(double yPos){
        this.yPos = yPos;
    }

    @Override
    public void setXY(double xPos, double yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public void setAngle(double positionAngle){
        this.positionAngle = positionAngle;
    }

    @Override
    public double getX(){
        return xPos;
    }

    @Override
    public double getY(){
        return yPos;
    }

    @Override
    public double[] getXY() {
        return new double[]{xPos, yPos};
    }

    @Override
    public double getAngle(){
        return positionAngle;
    }

    @Override
    public void move(){
        xPos += currentSpeed * Math.cos(positionAngle);
        yPos += currentSpeed * Math.sin(positionAngle);
    }

    @Override
    public void turnRight() {
        positionAngle -= 5 * Math.PI / 180;     //amount degrees
    }

    @Override
    public void turnLeft(){
        positionAngle += 5 * Math.PI / 180;     //amount degrees
    } 

}
