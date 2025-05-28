
interface VehicleInterface {
    int getMaxSpeed();
}


class Car implements VehicleInterface {
    @Override
    public int getMaxSpeed() {
        return 200;
    }
}


class Bicycle implements VehicleInterface {
    @Override
    public int getMaxSpeed() {
        return 30;
    }
}

class SpeedProvider {
    public int fetchSpeed() {
        return 100;
    }
}

class VehicleAdapter implements VehicleInterface {
    private SpeedProvider adaptee;

    public VehicleAdapter(SpeedProvider adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int getMaxSpeed() {
        return adaptee.fetchSpeed();
    }
}


public class Main {
    public static void main(String[] args) {
        VehicleInterface[] vehicles = {
            new Car(),
            new Bicycle(),
            new VehicleAdapter(new SpeedProvider())
        };

        for (VehicleInterface v : vehicles) {
            System.out.println("Tốc độ tối đa: " + v.getMaxSpeed() + " km/h");
        }
    }
}
