class Car is
   
class Manual is
   
interface Builder is
    method reset()
    method setSeats(...)
    method setEngine(...)
    method setTripComputer(...)
    method setGPS(...)

class CarBuilder implements Builder is
    private field car:Car

    constructor CarBuilder() is
        this.reset()

    // The reset method clears the object being built.
    method reset() is
        this.car = new Car()

    method setSeats(...) is
    
    method setEngine(...) is
       
    method setTripComputer(...) is
       
    method setGPS(...) is
    
    method getProduct():Car is
        product = this.car
        this.reset()
        return product

class CarManualBuilder implements Builder is
    private field manual:Manual

    constructor CarManualBuilder() is
        this.reset()

    method reset() is
        this.manual = new Manual()

    method setSeats(...) is
        // Document car seat features.

    method setEngine(...) is
      

    method setTripComputer(...) is
     
    method setGPS(...) is
      
    method getProduct():Manual is
       
class Director is
    
    method constructSportsCar(builder: Builder) is
        builder.reset()
        builder.setSeats(2)
        builder.setEngine(new SportEngine())
        builder.setTripComputer(true)
        builder.setGPS(true)

    method constructSUV(builder: Builder) is
    
class Application is

    method makeCar() is
        director = new Director()

        CarBuilder builder = new CarBuilder()
        director.constructSportsCar(builder)
        Car car = builder.getProduct()

        CarManualBuilder builder = new CarManualBuilder()
        director.constructSportsCar(builder)
      
        Manual manual = builder.getProduct()