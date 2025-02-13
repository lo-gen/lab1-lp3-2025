import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test extends CarTest{
    private Saab95 saab = new Saab95();

    public Saab95Test(){
        super(new Saab95());
    }

    @Test
    void setTurboOn() {
        saab.setTurboOff();
        saab.setTurboOn();
        assertTrue(saab.getTurboOn());
    }

    @Test
    void setTurboOff() {
        saab.setTurboOn();
        saab.setTurboOff();
        assertFalse(saab.getTurboOn());
    }

    @Test
    @Override
    void testSpeedFactor() {
        if (saab.getTurboOn()){
            assertEquals(saab.getEnginePower() * 0.01 * 1.3, saab.speedFactor());
        } else {
            assertEquals(saab.getEnginePower() * 0.01, saab.speedFactor());
        }
    }
}