import java.awt.*;

public abstract class Car implements IMovable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double xPos;
    private double yPos;
    private double positionAngle;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    protected void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    protected void setEnginePower(double enginePower){
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = Math.min(enginePower, currentSpeed);
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color color){
        this.color = color;
    }

    public String getModelName(){
        return modelName;
    }

    protected void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount){
        amount = Math.min(1, Math.max(0, amount));  //Math.clamp(0, 1, amount)
        incrementSpeed(amount);
    }

    public void brake(double amount){
        amount = Math.min(1, Math.max(0, amount));
        decrementSpeed(amount);
    }

    protected void setX(double xPos){
        this.xPos = xPos;
    }

    protected void setY(double yPos){
        this.yPos = yPos;
    }

    protected void setXY(double xPos, double yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    protected void setAngle(double positionAngle){
        this.positionAngle = positionAngle;
    }

    public double getX(){
        return xPos;
    }

    public double getY(){
        return yPos;
    }

    public double[] getXY() {
        return new double[]{xPos, yPos};
    }

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
