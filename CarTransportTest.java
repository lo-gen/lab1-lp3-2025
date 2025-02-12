import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest extends CarTest {
    CarTransport<IPassagerCar> carTransport = new CarTransport<>(10);
    Volvo240 volvo1 = new Volvo240();
    Saab95 saab1 = new Saab95();

    public CarTransportTest(){
        super(new CarTransport<>(10));
    }

    @Test
    void testSpeedFactor() {
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

    }

    @Test
    void getSpaceLeft() {
    }

    @Test
    void addCar() {
    }

    @Test
    void removeCar() {
    }

    @Test
    void testGas() {
    }

    @Test
    void testMove() {
    }
}