// Vehicle interface: Cầu nối
interface Vehicle {
    boolean isRunning();
    void start();
    void stop();
    int getSpeed();
    void setSpeed(int speed);
}

// Concrete implementation: Car
class Car implements Vehicle {
    private boolean running = false;
    private int speed = 0;

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void start() {
        running = true;
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        running = false;
        speed = 0;
        System.out.println("Car stopped.");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("Car speed set to " + speed + " km/h.");
    }
}

// Concrete implementation: Bicycle
class Bicycle implements Vehicle {
    private boolean running = false;
    private int speed = 0;

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void start() {
        running = true;
        System.out.println("Bicycle started.");
    }

    @Override
    public void stop() {
        running = false;
        speed = 0;
        System.out.println("Bicycle stopped.");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("Bicycle speed set to " + speed + " km/h.");
    }
}

// VehicleController: Cầu nối điều khiển phương tiện
class VehicleController {
    protected Vehicle vehicle;

    public VehicleController(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void toggleEngine() {
        if (vehicle.isRunning()) {
            vehicle.stop();
        } else {
            vehicle.start();
        }
    }

    public void accelerate() {
        int currentSpeed = vehicle.getSpeed();
        vehicle.setSpeed(currentSpeed + 10);
    }

    public void brake() {
        int currentSpeed = vehicle.getSpeed();
        vehicle.setSpeed(Math.max(currentSpeed - 10, 0));
    }
}

// AdvancedController: mở rộng VehicleController
class AdvancedController extends VehicleController {

    public AdvancedController(Vehicle vehicle) {
        super(vehicle);
    }

    public void turboBoost() {
        if (vehicle.isRunning()) {
            vehicle.setSpeed(vehicle.getSpeed() + 50);
            System.out.println("Turbo boost activated!");
        } else {
            System.out.println("Cannot boost. Vehicle is not running.");
        }
    }
}

// Test program
public class BridgePatternDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        VehicleController carController = new VehicleController(car);

        carController.toggleEngine();
        carController.accelerate();
        carController.brake();

        Vehicle bicycle = new Bicycle();
        AdvancedController bikeController = new AdvancedController(bicycle);

        bikeController.toggleEngine();
        bikeController.accelerate();
        bikeController.turboBoost();
        bikeController.brake();
    }
}
