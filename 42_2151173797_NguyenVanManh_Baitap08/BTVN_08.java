// Mediator Interface
interface Mediator {
    void notify(Object sender);
}

// Component: Car
class Car {
    private Mediator mediator;

    public Car(Mediator mediator) {
        this.mediator = mediator;
    }

    public int CretMaxSpeed() {
        int speed = 200;
        System.out.println("Car max speed: " + speed + " km/h");
        mediator.notify(this);
        return speed;
    }
}

// Component: Bicycle
class Bicycle {
    private Mediator mediator;

    public Bicycle(Mediator mediator) {
        this.mediator = mediator;
    }

    public int CretMaxSpeed() {
        int speed = 40;
        System.out.println("Bicycle max speed: " + speed + " km/h");
        mediator.notify(this);
        return speed;
    }
}

// Concrete Mediator: MediatorVehicle
class MediatorVehicle implements Mediator {
    private Car car;
    private Bicycle bicycle;

    public void setCar(Car car) {
        this.car = car;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public void notify(Object sender) {
        if (sender instanceof Car) {
            reactOnCar();
        } else if (sender instanceof Bicycle) {
            reactOnBicycle();
        }
    }

    public void reactOnCar() {
        System.out.println("Mediator reacts to Car: Notifying Bicycle about Car's speed.");
        if (bicycle != null) {
            bicycle.CretMaxSpeed();
        }
    }

    public void reactOnBicycle() {
        System.out.println("Mediator reacts to Bicycle: Notifying Car about Bicycle's speed.");
        if (car != null) {
            car.CretMaxSpeed();
        }
    }
}

// Test Program
public class MediatorPatternDemo {
    public static void main(String[] args) {
        MediatorVehicle mediator = new MediatorVehicle();

        Car car = new Car(mediator);
        Bicycle bicycle = new Bicycle(mediator);

        mediator.setCar(car);
        mediator.setBicycle(bicycle);

        // Test tương tác
        System.out.println(">>> Car triggers CretMaxSpeed:");
        car.CretMaxSpeed();

        System.out.println("\n>>> Bicycle triggers CretMaxSpeed:");
        bicycle.CretMaxSpeed();
    }
}
