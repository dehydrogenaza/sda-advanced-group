import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarService {

    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

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
