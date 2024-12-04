package app.service;

import app.model.Car;

import java.math.BigDecimal;
import java.util.List;

// Serwis odpowiedzialny za logikę biznesową dotyczącą samochodów
public interface CarService {

    // Dodanie nowego samochodu
    void addCar(Long id, String brand, BigDecimal price, int year);

    // Pobranie samochodu po identyfikatorze
    Car getCarById(Long id);

    // Aktualizacja istniejącego samochodu
    void updateCar(Long id, String brand, BigDecimal price, int year);

    // Usunięcie samochodu po identyfikatorze
    void deleteCar(Long id);

    // Pobranie listy wszystkich samochodów
    List<Car> getAllCars();

    // Metoda pomocnicza do ustawiania artykułu dla samochodu
    void setArticle(Car car);
}
