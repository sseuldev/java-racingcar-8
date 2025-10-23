package racingcar.domain;

import racingcar.exception.ErrorMessages;

public class Car {

    private static final int MAXIMUM_CAR_LENGTH = 5;

    private final String name;
    private int distance = 0;

    public Car(String name){
        validateName(name);
        this.name = name;
    }

    public Car(String name, int distance) {
        validateName(name);
        this.name = name;
        this.distance = distance;
    }

    public void move() {
        distance++;
    }

    private void validateName(String name) {
        validateNameEmpty(name);
        validateNameLength(name);
    }

    private void validateNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_EMPTY);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_CAR_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
