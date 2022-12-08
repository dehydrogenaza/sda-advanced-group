import java.util.List;

public class CarService {

    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    public void addCars(Car car) {
        cars.add(car);
    }

    public Car getCheapestCar(List<Car> cars) {
        Car cheapestCar = null;
        int cheapestCarPrice = 0;
        for (Car car : cars) {
            if (car.getPrice() < cheapestCarPrice) {
                cheapestCar = car;
            }
        }
        return cheapestCar;
    }
}
