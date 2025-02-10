import java.awt.*;

public interface IVehicle extends IMovable {
    int getNrDoors();
    void setNrDoors(int NrDoors);
    double getEnginePower();
    void setEnginePower(double enginePower);
    double getCurrentSpeed();
    void setCurrentSpeed(double currentsSpeed);
    Color getColor();
    void setColor(Color color);
    String getModelName();
    void setModelName(String Name);
    void startEngine();
    void stopEngine();
    double speedFactor();
    void incrementSpeed(double amount);
    void decrementSpeed(double amount);
    void gas(double amount);
    void brake(double amount);
    void setX(double xPos);
    void setY(double yPos);
    void setXY(double xPos, double yPos);
    void setAngle(double positionAngle);
    double getX();
    double getY();
    double[] getXY();
    double getAngle();

}
