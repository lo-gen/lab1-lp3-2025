import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public abstract class CarTest {
    private Car car;

    public CarTest(Car car){
        this.car = car;
    }

    @org.junit.jupiter.api.Test
    public void getNrDoors() {
        car.setNrDoors(5);
        assertEquals(5, car.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    public void setNrDoors() {
        car.setNrDoors(3);
        assertEquals(3, car.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    public void getEnginePower() {
        car.setEnginePower(100);
        assertEquals(100, car.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    public void setEnginePower() {
        car.setEnginePower(69);
        assertEquals(69, car.getEnginePower());
    }
    @org.junit.jupiter.api.Test
    public void getCurrentSpeed() {
        car.setCurrentSpeed(5);
        assertEquals(5, car.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    public void setCurrentSpeed() {
        car.setCurrentSpeed(50);
        assertEquals(50, car.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    public void getColor() {
        car.setColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getColor());
    }

    @org.junit.jupiter.api.Test
    public void setColor() {
        car.setColor(Color.PINK);
        assertEquals(Color.PINK, car.getColor());
    }

    @org.junit.jupiter.api.Test
    public void startEngine() {
        car.stopEngine();
        car.startEngine();
        assertTrue(0 < car.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    public void stopEngine() {
        car.startEngine();
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    public abstract void speedFactor();

    @org.junit.jupiter.api.Test
    public void incrementSpeed() {
        double speed = car.getCurrentSpeed();
        car.gas(5);
        if (speed < car.getEnginePower()){
            assertTrue(speed < car.getCurrentSpeed());
            assertFalse(car.getEnginePower() < car.getCurrentSpeed());
        } else {
            assertEquals(speed, car.getCurrentSpeed());
        }
    }

    @org.junit.jupiter.api.Test
    public void decrementSpeed() {
        double speed = car.getCurrentSpeed();
        car.brake(5);
        if (0 < speed){
            assertTrue( car.getCurrentSpeed() < speed);
            assertFalse(car.getCurrentSpeed() < 0);
        } else {
            assertEquals(0, car.getCurrentSpeed());
        }
    }

    @org.junit.jupiter.api.Test
    public void gas() {
        double speed = car.getCurrentSpeed();
        car.gas(0.5);
        if (speed < car.getEnginePower()){
            assertTrue(speed < car.getCurrentSpeed());
            assertFalse(car.getEnginePower() < car.getCurrentSpeed());
        } else {
            assertEquals(speed, car.getCurrentSpeed());
        }
    }

    @org.junit.jupiter.api.Test
    public void brake() {
        double speed = car.getCurrentSpeed();
        car.brake(0.3);
        if (0 < speed){
            assertTrue(speed < car.getCurrentSpeed());
            assertFalse(car.getCurrentSpeed() < 0);
        } else {
            assertEquals(0, car.getCurrentSpeed());
        }
    }

    @org.junit.jupiter.api.Test
    public void setAngle() {
        car.setAngle(10);
        assertEquals(10, car.getAngle());
    }

    @org.junit.jupiter.api.Test
    public void setXPos() {
        car.setXPos(10);
        assertEquals(10, car.getXPos());
    }

    @Test
    public void setYPos() {
        car.setYPos(20);
        assertEquals(20, car.getYPos());
    }

    @org.junit.jupiter.api.Test
    public void getXPos() {
        car.setXPos(15);
        assertEquals(15, car.getXPos());
    }

    @org.junit.jupiter.api.Test
    public void getYPos() {
        car.setYPos(30);
        assertEquals(30, car.getYPos());
    }

    @org.junit.jupiter.api.Test
    public void move() {
        double x = car.getXPos();
        double y = car.getYPos();
        car.setCurrentSpeed(10);
        car.move();
        if (0 < Math.cos(car.getAngle())) {
            assertTrue(x < car.getXPos());
        } else if (Math.cos(car.getAngle()) < 0) {
            assertTrue(car.getXPos() < x);
        } else {
            assertEquals(x, car.getXPos());
        }
        if (0 < Math.sin(car.getAngle())) {
            assertTrue(y < car.getYPos());
        } else if (Math.sin(car.getAngle()) < 0) {
            assertTrue(car.getYPos() < y);
        } else {
            assertEquals(y, car.getYPos());
        }
    }

    @org.junit.jupiter.api.Test
    public void turnRight() {
        double angle = car.getAngle();
        car.turnRight();
        assertTrue(car.getAngle() < angle);
    }

    @org.junit.jupiter.api.Test
    public void turnLeft() {
        double angle = car.getAngle();
        car.turnLeft();
        assertTrue(angle < car.getAngle());
    }


}