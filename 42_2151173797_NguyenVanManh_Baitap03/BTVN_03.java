// Product: Vehicle
interface Vehicle {
    int getMaxSpeed();
}

// ConcreteProductA: Car
class Car implements Vehicle {
    @Override
    public int getMaxSpeed() {
        return 200;
    }
}

// ConcreteProductB: Bicycle
class Bicycle implements Vehicle {
    @Override
    public int getMaxSpeed() {
        return 30;
    }
}

// Creator: VehicleFactory
abstract class VehicleFactory {
    public abstract Vehicle createVehicle();
}

// ConcreteCreatorA: CarFactory
class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

// ConcreteCreatorB: BicycleFactory
class BicycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bicycle();
    }
}

// Chương trình chính kiểm tra
public class Main {
    public static void main(String[] args) {
        // Tạo mảng chứa các Vehicle bằng Factory Method
        VehicleFactory[] factories = new VehicleFactory[2];
        factories[0] = new CarFactory();
        factories[1] = new BicycleFactory();

        Vehicle[] vehicles = new Vehicle[2];
        for (int i = 0; i < factories.length; i++) {
            vehicles[i] = factories[i].createVehicle();
        }

        // In tốc độ tối đa của từng phương tiện
        for (Vehicle v : vehicles) {
            System.out.println("Max speed: " + v.getMaxSpeed() + " km/h");
        }
    }
}