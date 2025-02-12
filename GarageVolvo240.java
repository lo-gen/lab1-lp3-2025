public class GarageVolvo240{

    public GarageVolvo240(){
    }

    public static void main(String[] args) {
        Saab95 saab1 = new Saab95();
        Volvo240 volvo1 = new Volvo240();
        Volvo240 volvo2 = new Volvo240();
        CarTransport<IPassagerCar> biltrans = new CarTransport<>(5);
        Garage<Volvo240> garage1 = new Garage<>(20, 10, 10);

        volvo1.setXPos(123);
        saab1.setYPos(3);

        biltrans.rampDown();
        biltrans.addCar(volvo1);
        biltrans.addCar(saab1);
        biltrans.rampUp();

        System.out.println(biltrans.getSpaceUsed());

        System.out.println("saab pos:" + saab1.getXPos() + ", " + saab1.getYPos());
        biltrans.gas(50);
        biltrans.move();
        System.out.println("biltrans pos:" + biltrans.getXPos() + ", " + biltrans.getYPos());
        System.out.println("saab pos:" + saab1.getXPos() + ", " + saab1.getYPos());
        biltrans.setCurrentSpeed(0);
        biltrans.rampDown();
        biltrans.removeCar();
        System.out.println("biltrans pos:" + biltrans.getXPos() + ", " + biltrans.getYPos());
        System.out.println("saab pos:" + saab1.getXPos() + ", " + saab1.getYPos());

    }
}
