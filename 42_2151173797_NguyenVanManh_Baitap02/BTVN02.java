// Lớp cha
public abstract class Vehicle {
    public abstract int getMaxSpeed();
}

// Lớp con Car kế thừa Vehicle
public class Car extends Vehicle {
    @Override
    public int getMaxSpeed() {
        return 200;
    }
}

// Lớp con Bicycle kế thừa Vehicle
public class Bicycle extends Vehicle {
    @Override
    public int getMaxSpeed() {
        return 30;
    }
}
public class TestVehicle {
    public static void main(String[] args) {
        // Mảng kiểu Vehicle chứa Car và Bicycle
        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Car();
        vehicles[1] = new Bicycle();

        // In tốc độ tối đa của từng phương tiện
        for (Vehicle v : vehicles) {
            System.out.println("Max speed: " + v.getMaxSpeed() + " km/h");
        }
    }
}
