package racingcar.domain;

import racingcar.helper.RandomNumberHelper;

import java.util.List;

public class Race {

    private static final int MINIMUM_MOVE_NUMBER = 4;

    private final Cars cars;
    private final RandomNumberHelper randomNumberHelper;

    public Race(Cars cars, RandomNumberHelper randomNumberHelper) {
        this.cars = cars;
        this.randomNumberHelper = randomNumberHelper;
    }

    public void decideMove() {
        cars.getCars().stream()
                .filter(car -> isMovable())
                .forEach(Car::move);
    }

    public List<Car> decideWinner() {
        return cars.findWinners();
    }

    private boolean isMovable() {
        return randomNumberHelper.generate() >= MINIMUM_MOVE_NUMBER;
    }
}
