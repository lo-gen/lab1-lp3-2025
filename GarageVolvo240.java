public class GarageVolvo240{

    public GarageVolvo240(){
    }

    public static void main(String[] args) {
        Saab95 Car1 = new Saab95();  // Object 1
        Volvo240 Car2 = new Volvo240();
        Volvo240 Car3 = new Volvo240();
        Scania lastbilen = new Scania();
        Garage<Volvo240> myVolvoGarage = new Garage<>(10, 10, 10);
        Garage<Car> myEqualityGarage = new Garage<>(5, 0, 35);

        myVolvoGarage.addCar(Car2);
        myEqualityGarage.addCar(Car3);
        myEqualityGarage.addCar(Car1);
        myEqualityGarage.addCar(lastbilen);
        System.out.println(myEqualityGarage.getSpaceUsed());

        CarTransport<Car> myTransport= new CarTransport<>(5);
        myTransport.addCar(Car1);
        myTransport.addCar(Car2);
        myTransport.addCar(Car3);
        myTransport.addCar(lastbilen);
        System.out.println(myTransport.getSpaceUsed());
        myTransport.removeCar();
        System.out.println(myTransport.getSpaceUsed());
        myTransport.addCar(Car3);
        System.out.println(myTransport.getSpaceUsed());
        myTransport.addCar(Car3);
        myTransport.addCar(Car3);
        myTransport.addCar(Car3);
        myTransport.addCar(Car3);
        myTransport.addCar(Car3);
        myTransport.addCar(Car3);
        System.out.println(myTransport.getSpaceUsed());

    }
}
