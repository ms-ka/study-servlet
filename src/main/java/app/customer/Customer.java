package app.customer;

import app.controller.CarController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import java.math.BigDecimal;

// Klasa główna uruchamiająca aplikację i imituje działania klienta
@Configuration
@ComponentScan("app")
public class Customer {
    public static void main(String[] args) {
        // Tworzenie kontekstu aplikacji Spring, skanującego pakiet "app"
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app");

        // Pobranie kontrolera samochodów z kontekstu
        CarController controller = context.getBean(CarController.class);

        // Dodanie kilku samochodów
        controller.addCar(1L, "Toyota", BigDecimal.valueOf(23000), 2024);
        controller.addCar(2L, "Honda", BigDecimal.valueOf(3000), 2015);
        controller.addCar(3L, "Ford", BigDecimal.valueOf(7000), 2014);

        // Wyświetlenie wszystkich samochodów
        System.out.println("\nAll autos:");
        controller.listAllCars();

        // Wyszukiwanie samochodu po identyfikatorze
        System.out.println("\nFound auto with ID 2:");
        controller.showCar(2L);

        // Aktualizacja samochodu
        System.out.println("\nUpdate information about Car with ID 2:");
        controller.updateCar(2L, "Fiat", BigDecimal.valueOf(9000), 2018);

        // Wyświetlenie samochodu po aktualizacji
        System.out.println("\nFount auto with ID 2 after actualisation:");
        controller.showCar(2L);

        // Usunięcie samochodu
        System.out.println("\nDelete auto with ID 3 :");
        controller.deleteCar(3L);

        // Wyświetlenie wszystkich samochodów po usunięciu
        System.out.println("\nAll autos after delete :");
        controller.listAllCars();
    }
}
