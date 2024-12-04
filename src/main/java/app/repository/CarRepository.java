package app.repository;

import app.model.Car;
import java.util.List;


public interface CarRepository {

    //otrzymanie wszystkich samochodów
    List<Car> getAll();

    //przechowanie samochodów w bazie danych
    Car save (Car car);

    // Aktualizacja samochodu w bazie danych
    Car update(Car car);

    // Usunięcie samochodu z bazy danych po identyfikatorze
    void delete(long id);

    // Znalezienie samochodu po identyfikatorze
    Car findById(long id);
}

