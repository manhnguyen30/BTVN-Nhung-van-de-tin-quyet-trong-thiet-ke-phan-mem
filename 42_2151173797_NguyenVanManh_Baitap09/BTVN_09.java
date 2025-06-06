// Interface VehicleStrategy
interface VehicleStrategy {
    int getMaxSpeed();
}

// Concrete Strategy: Car
class Car implements VehicleStrategy {
    @Override
    public int getMaxSpeed() {
        return 200;
    }
}

// Concrete Strategy: Bicycle
class Bicycle implements VehicleStrategy {
    @Override
    public int getMaxSpeed() {
        return 40;
    }
}

// Context class
class Context {
    private VehicleStrategy strategy;

    public void setStrategy(VehicleStrategy strategy) {
        this.strategy = strategy;
    }

    public void showMaxSpeed() {
        if (strategy != null) {
            System.out.println("Max speed: " + strategy.getMaxSpeed() + " km/h");
        } else {
            System.out.println("No vehicle strategy set.");
        }
    }
}

// Client class
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        // Set strategy to Car
        context.setStrategy(new Car());
        context.showMaxSpeed();

        // Set strategy to Bicycle
        context.setStrategy(new Bicycle());
        context.showMaxSpeed();
    }
}
