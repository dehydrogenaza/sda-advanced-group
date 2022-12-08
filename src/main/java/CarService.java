import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> carsWithV12Engine() {
        List<Car> v12Cars = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getEngine().equals(Engine.V12)) {
                v12Cars.add(cars.get(i));
            }
        }
        return v12Cars;
    }

    public boolean isInTheList (Car car) {
        for (int i = 0; i<cars.size(); i++) {
            if (car.equals(cars.get(i))) return true;
        }
        return false;
    }

    public List <Car> carsBefore1999 () {
        List <Car> carList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < 1999) carList.add(car);
        }

        return carList;
    }
}
