import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    private Garage<Volvo240> volvo240Garage;
    private Garage<IPassagerCar> passagerCarGarage;
    private Garage<ICar> carGarage;
    private Volvo240 volvo1 = new Volvo240();
    private Saab95 saab1 = new Saab95();
    private Scania scania1 = new Scania();

    public GarageTest(){
        carGarage = new Garage<>(10,50,40);

    }

    @Test
    void getXPos() {
        assertEquals(50,carGarage.getXPos());
    }

    @Test
    void getYPos() {
        assertEquals(40,carGarage.getYPos());
    }

    @Test
    void getSpaceUsed() {
        carGarage.addCar(volvo1);
        carGarage.addCar(scania1);
        assertEquals(2, carGarage.getSpaceUsed());
    }

    @Test
    void getSpaceLeft() {
        carGarage.addCar(volvo1);
        carGarage.addCar(saab1);
        assertEquals(8,carGarage.getSpaceLeft());
    }

    @Test
    void addCar() {
        carGarage.addCar(volvo1);
        assertEquals(1,carGarage.getSpaceUsed());
    }

    @Test
    void removeItem() {
        carGarage.addCar(volvo1);
        carGarage.removeItem(volvo1);
        assertEquals(0,carGarage.getSpaceUsed());
    }
}