import org.junit.jupiter.api.BeforeEach;

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
    public void setX() {
        car.setX(10);
        assertEquals(10, car.getX());
    }

    @org.junit.jupiter.api.Test
    public void setY() {
        car.setY(20);
        assertEquals(20, car.getY());
    }

    @org.junit.jupiter.api.Test
    public void getX() {
        car.setX(15);
        assertEquals(15, car.getX());
    }

    @org.junit.jupiter.api.Test
    public void getY() {
        car.setY(30);
        assertEquals(30, car.getY());
    }

    @org.junit.jupiter.api.Test
    public void move() {
        double x = car.getX();
        double y = car.getY();
        car.setCurrentSpeed(10);
        car.move();
        if (0 < Math.cos(car.getAngle())) {
            assertTrue(x < car.getX());
        } else if (Math.cos(car.getAngle()) < 0) {
            assertTrue(car.getX() < x);
        } else {
            assertEquals(x, car.getX());
        }
        if (0 < Math.sin(car.getAngle())) {
            assertTrue(y < car.getY());
        } else if (Math.sin(car.getAngle()) < 0) {
            assertTrue(car.getY() < y);
        } else {
            assertEquals(y, car.getY());
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