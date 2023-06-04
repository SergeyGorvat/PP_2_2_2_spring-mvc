package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    private static int carsCount;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++carsCount, "Ford", 1));
        cars.add(new Car(++carsCount, "Renault", 2));
        cars.add(new Car(++carsCount, "Ferrari", 3));
        cars.add(new Car(++carsCount, "BMW", 4));
        cars.add(new Car(++carsCount, "Mercedes", 5));
    }

    @Override
    public List<Car> getCarsByCount(int count) {

        if (count > 0 & count <= cars.size()) {
            return cars.stream().limit(count).toList();
        }
        return cars;
    }
}
