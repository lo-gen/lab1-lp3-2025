import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest extends CarTest {
    CarTransport<IPassagerCar> carTransport = new CarTransport<>(10);
    Volvo240 volvo1 = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Volvo240 volvo3 = new Volvo240();
    Volvo240 volvo4 = new Volvo240();
    Volvo240 volvo5 = new Volvo240();
    Volvo240 volvo6 = new Volvo240();
    Volvo240 volvo7 = new Volvo240();
    Volvo240 volvo8 = new Volvo240();
    Volvo240 volvo9 = new Volvo240();
    Volvo240 volvo10 = new Volvo240();
    Saab95 saab1 = new Saab95();

    public CarTransportTest(){
        super(new CarTransport<>(10));
    }

    @Test
    public void testSpeedFactor() {
        assertEquals(500*0.001, carTransport.speedFactor());
    }

    @Test
    void rampUp() {
        carTransport.setCurrentSpeed(0);
        carTransport.rampDown();
        carTransport.rampUp();
        assertTrue(carTransport.getRampUpStatus());
    }

    @Test
    void rampDown() {
        carTransport.setCurrentSpeed(0);
        carTransport.rampUp();
        carTransport.setCurrentSpeed(50);
        carTransport.rampDown();
        assertTrue(carTransport.getRampUpStatus());
        carTransport.setCurrentSpeed(0);
        carTransport.rampDown();
        assertFalse(carTransport.getRampUpStatus());
    }

    @Test
    void getRampUpStatus() {
        carTransport.rampUp();
        assertTrue(carTransport.getRampUpStatus());
    }

    @Test
    void getSpaceUsed() {
        carTransport.removeCar();
        carTransport.removeCar();
        carTransport.addCar(volvo1);
        carTransport.addCar(volvo1);
        carTransport.addCar(saab1);
        assertEquals(2, carTransport.getSpaceUsed());
    }

    @Test
    void getSpaceLeft() {
        carTransport.addCar(volvo1);
        carTransport.addCar(saab1);
        assertEquals(8, carTransport.getSpaceLeft());
    }

    @Test
    void addCar() {
        carTransport.setXYPos(0, 0);
        volvo1.setXYPos(0,0);
        carTransport.rampDown();
        carTransport.rampUp();
        carTransport.addCar(volvo1);
        assertEquals(0, carTransport.getSpaceUsed());
        carTransport.rampDown();
        volvo1.setXYPos(20,20);
        carTransport.addCar(volvo1);
        assertEquals(0, carTransport.getSpaceUsed());
        volvo1.setXYPos(0,0);
        carTransport.addCar(volvo1);
        assertEquals(1, carTransport.getSpaceUsed());
        assertSame(volvo1, carTransport.getCars().getFirst());
        carTransport.addCar(volvo2);
        carTransport.addCar(volvo3);
        carTransport.addCar(volvo4);
        carTransport.addCar(volvo5);
        carTransport.addCar(volvo6);
        carTransport.addCar(volvo7);
        carTransport.addCar(volvo8);
        carTransport.addCar(volvo9);
        carTransport.addCar(volvo10);
        carTransport.addCar(volvo1);
        assertEquals(10, carTransport.getSpaceUsed());
    }

    @Test
    void removeCar() {
        carTransport.rampDown();
        carTransport.addCar(volvo1);
        carTransport.addCar(saab1);
        carTransport.rampUp();
        carTransport.removeCar();
        carTransport.removeCar();
        assertEquals(2, carTransport.getSpaceUsed());
        carTransport.rampDown();
        carTransport.removeCar();
        carTransport.removeCar();
        assertEquals(0, carTransport.getSpaceUsed());
    }

    @Test
    @Override
    public void incrementSpeed() {
        gas();
    }

    @Test
    @Override
    public void gas() {
        carTransport.rampUp();
        double oldSpeed = carTransport.getCurrentSpeed();
        carTransport.gas(50);
        assertTrue(oldSpeed < carTransport.getCurrentSpeed());
        carTransport.setCurrentSpeed(0);
        carTransport.rampDown();
        carTransport.gas(20);
        assertEquals(0, carTransport.getCurrentSpeed());
    }

    @Test
    void testMove() {
        carTransport.setXYPos(5, 5);
        volvo1.setXYPos(6, 6);
        carTransport.rampDown();
        carTransport.addCar(volvo1);
        carTransport.rampUp();
        carTransport.setCurrentSpeed(50);
        carTransport.move();
        assertEquals(carTransport.getXPos(), volvo1.getXPos());
        assertEquals(carTransport.getYPos(), volvo1.getYPos());
    }
}