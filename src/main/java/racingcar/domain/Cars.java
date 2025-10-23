package racingcar.domain;

import racingcar.exception.ErrorMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicate(names);
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> findWinners() {
        int max = findMaxDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == max)
                .toList();
    }

    private void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_CAR_NAME);
        }
    }

    private int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
