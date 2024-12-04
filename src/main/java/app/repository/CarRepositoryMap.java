package app.repository;

import app.model.Car;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CarRepositoryMap implements CarRepository{
    // Map przechowująca samochody z ich identyfikatorem jako kluczem
    private Map<Long, Car>database = new HashMap<>();
    private long currentId;

    public CarRepositoryMap() {
        initDat();
    }

    private void initDat() {
        save(new Car("VW", new BigDecimal(10000), 2012));
        save(new Car("Fiat", new BigDecimal(8000), 2010));
        save(new Car("Volvo", new BigDecimal(15000), 2018));
    }

    // Otrzymanie wszystkich samochodów
    @Override
    public List<Car> getAll() {
        return new ArrayList<>(database.values());
        //alternatywnie
        //return database.values().stream().toList();
    }

    // Przechowanie samochodu w bazie danych
    @Override
    public Car save(Car car) {
        car.setId(++currentId);
        database.put(car.getId(), car);
        return car;
    }

    // Aktualizacja samochodu w bazie danych
    @Override
    public Car update(Car car) {
        if (database.containsKey(car.getId())) {
            database.put(car.getId(), car);
            return car;
        } else {
            throw new IllegalArgumentException("Car with ID " + car.getId() + " does not exist.");
        }
    }

    // Usunięcie samochodu z bazy danych po identyfikatorze
    @Override
    public void delete(long id) {
        database.remove(id);
    }

    // Znalezienie samochodu po identyfikatorze
    @Override
    public Car findById(long id) {
        return database.get(id);
    }
}
