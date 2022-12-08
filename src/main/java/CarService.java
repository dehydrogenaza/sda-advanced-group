import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarService {

    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }
    
    //4
    public List<Car> carsWithV12Engine() {
        List<Car> v12Cars = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getEngine().equals(Engine.V12)) {
                v12Cars.add(cars.get(i));
            }
        }
        return v12Cars;
    }

    //6
    public Optional<Car> getMostExpensive() {
        int highestPrice = -1;
        Car mostExpensiveCar = null;

        for (Car car : cars) {
            int price = car.getPrice();
            if (price > highestPrice) {
                highestPrice = price;
                mostExpensiveCar = car;
            }
        }

        return Optional.ofNullable(mostExpensiveCar);
    }
    
    //10
    public boolean isInTheList (Car car) {
        for (int i = 0; i<cars.size(); i++) {
            if (car.equals(cars.get(i))) return true;
        }
        return false;

    }

    //12
    public List<Car> getByManufacturerAndYear(Manufacturer manufacturer, int year, Comparison comparison) {
        Predicate<Car> predicate = switch(comparison) {
            case LOWER -> car -> car.getYear() < year;
            case GREATER -> car -> car.getYear() > year;
            case LOWER_OR_EQUAL -> car -> car.getYear() <= year;
            case GREATER_OR_EQUAL -> car -> car.getYear() >= year;
            case EQUAL -> car -> car.getYear() == year;
            case NOT_EQUAL -> car -> car.getYear() != year;
        };

        System.out.println(predicate);

        return cars.stream()
                .filter(car -> car.getManufacturers().contains(manufacturer))
                .filter(predicate)
                .collect(Collectors.toList());

}
}