package app.service;

import app.model.Car;
import app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

// Implementacja serwisu odpowiedzialnego za logikę biznesową dotyczącą samochodów
@Service
public class CarServiceImpl implements CarService {

    private CarRepository repository;
    private String articlePrefix;

    // Wartość konfiguracyjna pobrana z pliku `application.properties`
    public CarServiceImpl(CarRepository repository, @Value("${car.article.prefix}") String articlePrefix) {
        this.repository = repository;
        this.articlePrefix = articlePrefix;
    }

    // Dodanie nowego samochodu
    @Override
    public void addCar(Long id, String brand, BigDecimal price, int year) {
        Car car = new Car(brand, price, year);
        setArticle(car);
        repository.save(car);
        System.out.println("New car is added to DB: " + car);
    }

    // Pobranie samochodu po identyfikatorze
    @Override
    public Car getCarById(Long id) {
        Car car = repository.findById(id);
        if (car != null) {
            return car;
        } else {
            System.out.println("Car with ID " + id + " is not found.");
            return null;
        }
    }

    // Aktualizacja istniejącego samochodu
    @Override
    public void updateCar(Long id, String brand, BigDecimal price, int year) {
        Car existingCar = repository.findById(id);
        if (existingCar != null) {
            existingCar.setBrand(brand);
            existingCar.setPrice(price);
            existingCar.setYear(year);
            setArticle(existingCar);
            repository.update(existingCar);
            System.out.println(existingCar);
        } else {
            System.out.println("Car with ID " + id + " already exist.");
        }
    }

    // Usunięcie samochodu po identyfikatorze
    @Override
    public void deleteCar(Long id) {
        Car car = repository.findById(id);
        if (car != null) {
            repository.delete(id);
            System.out.println("Car with ID: " + id + " is delete");
        } else {
            System.out.println("Car with ID: " + id + " already exist.");
        }
    }

    // Pobranie listy wszystkich samochodów
    @Override
    public List<Car> getAllCars() {
        return repository.getAll();
    }

    // Metoda pomocnicza do ustawiania artykułu dla samochodu
    @Override
    public void setArticle(Car car) {
        // Tworzenie artykułu w formacie: PREFIX-ID-BRAND-PRICE-YEAR
        String article = String.format("Article_%d_%s_%.2f_%d", car.getId(), car.getBrand(), car.getPrice(), car.getYear());
        car.setArticle(article);
    }
}
