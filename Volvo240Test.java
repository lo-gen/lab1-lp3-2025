import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test extends CarTest{
    private Volvo240 volvo = new Volvo240();

    public Volvo240Test(){
        super(new Volvo240());
    }

    @Test
    @Override public void speedFactor() {
        assertEquals(volvo.getEnginePower() * 0.01 * 1.25, volvo.speedFactor());
    }
}