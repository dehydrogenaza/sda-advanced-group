import java.util.Objects;

public class Manufacturer {
    private String name;
    private int foundationYear;
    private String country;

    public Manufacturer(String name, int foundationYear, String country) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return foundationYear == that.foundationYear && Objects.equals(name, that.name) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foundationYear, country);
    }
}
