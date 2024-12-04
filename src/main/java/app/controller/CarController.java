package app.controller;

import app.model.Car;
import app.service.CarService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

// Kontroler zarządzający interakcją użytkownika z aplikacją dotyczącą samochodów
@Component
public class CarController {

    private final CarService service;

    // Konstruktor do wstrzykiwania serwisu
    public CarController(CarService service) {
        this.service = service;
    }

    // Dodanie samochodu przez użytkownika
    public void addCar(Long id, String brand, BigDecimal price, int year) {
        service.addCar(id, brand, price, year);
    }

    // Wyświetlenie informacji o samochodzie na podstawie identyfikatora
    public void showCar(Long id) {
        Car car = service.getCarById(id);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car is not found.");
        }
    }

    // Wyświetlenie wszystkich samochodów
    public void listAllCars() {
        List<Car> cars = service.getAllCars();
        if (cars.isEmpty()) {
            System.out.println("No cars in DB.");
        } else {
            cars.forEach(car -> System.out.println(car));
        }
    }

    // Aktualizacja samochodu po identyfikatorze
    public void updateCar(Long id, String brand, BigDecimal price, int year) {
        service.updateCar(id, brand, price, year);
    }

    // Usunięcie samochodu po identyfikatorze
    public void deleteCar(Long id) {
        service.deleteCar(id);
    }
}
