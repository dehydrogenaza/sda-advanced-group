import java.util.List;
import java.util.Objects;

public class Car {
    private final String name;
    private final String model;
    private final int price;
    private final int year;
    private final List<Manufacturer> manufacturers;
    private final Engine engine;

    public Car(String name, String model, int price, int year, List<Manufacturer> manufacturers, Engine engine) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.year = year;
        this.manufacturers = manufacturers;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        if (year != car.year) return false;
        if (!Objects.equals(name, car.name)) return false;
        if (!Objects.equals(model, car.model)) return false;
        if (!Objects.equals(manufacturers, car.manufacturers)) return false;
        return engine == car.engine;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + year;
        result = 31 * result + (manufacturers != null ? manufacturers.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        return result;
    }
}
