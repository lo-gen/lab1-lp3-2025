import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest extends CarTest {

    private Scania scania = new Scania();

    public ScaniaTest(){
        super(new Scania());
    }

    @Override
    public void speedFactor() {
        assertEquals(770*0.001, scania.speedFactor());
    }

    @Test
    void getRampAngle() {
        scania.setRampAngle(15);
        assertEquals(15, scania.getRampAngle());
    }

    @Test
    void setRampAngle() {
        scania.setRampAngle(15);
        assertEquals(15,scania.getRampAngle());
    }

    @Test
    void rampDown() {
        scania.setCurrentSpeed(0);
        scania.setRampAngle(45);
        int oldRampAngle = scania.getRampAngle();
        scania.rampDown(5);
        assertTrue(scania.getRampAngle() < oldRampAngle);
        scania.setRampAngle(1);
        scania.rampDown(69);
        assertEquals(0, scania.getRampAngle());
    }

    @Test
    void rampUp() {
        scania.setCurrentSpeed(0);
        scania.setRampAngle(45);
        int oldRampAngle = scania.getRampAngle();
        scania.rampUp(5);
        assertTrue(scania.getRampAngle() > oldRampAngle);
        scania.setRampAngle(0);
        scania.setCurrentSpeed(20);
        scania.rampUp(5);
        assertEquals(0, scania.getRampAngle());
        scania.setCurrentSpeed(0);
        scania.setRampAngle(69);
        scania.rampUp(69);
        assertEquals(70, scania.getRampAngle());
    }

    @Test
    void testSpeedFactor() {
        assertEquals(770*0.001, scania.speedFactor());
    }

    @Test
    void testGas() {
        scania.setRampAngle(0);
        double oldSpeed = scania.getCurrentSpeed();
        scania.gas(50);
        assertTrue(oldSpeed < scania.getCurrentSpeed());
        scania.setCurrentSpeed(0);
        scania.setRampAngle(10);
        scania.gas(20);
        assertEquals(0, scania.getCurrentSpeed());
    }
}