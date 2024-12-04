package app.model;

import java.math.BigDecimal;

public class Car {
    private Long id;
    private String brand;
    private BigDecimal price;
    private int year;
    private String article;

    public Car(String brand, BigDecimal price, int year) {
        this.brand = brand;
        this.price = price;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Car: id - %d, brand - %s, year - %d, price - %s", id, brand, year, price);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;

        return year == car.year && id.equals(car.id) && brand.equals(car.brand) && price.equals(car.price);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + brand.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + year;
        return result;
    }

}
