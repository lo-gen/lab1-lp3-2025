import java.awt.*;

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int x;
    private int y;
    private double angle;

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

    // TODO fix this method according to lab pm
    public void gas(double amount){
        amount = Math.min(1, Math.max(0, amount));
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        amount = Math.min(1, Math.max(0, amount));
        decrementSpeed(amount);
    }

    protected void setX(int x){
        this.x = x;
    }

    protected void setY(int y){
        this.y = y;
    }

    protected void setAngle(double angle){
        this.angle = angle;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double getAngle(){
        return angle;
    }

    @Override
    public void move(){
        x += (int)(currentSpeed * Math.cos(angle));
        y += (int)(currentSpeed * Math.sin(angle));
    }

    @Override
    public void turnRight(int amount) {
        angle -= amount * Math.PI / 180;     //5 degrees
    }

    @Override
    public void turnLeft(int amount){
        angle += amount * Math.PI / 180;     //5 degrees
    }
}
