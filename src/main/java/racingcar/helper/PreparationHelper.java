package racingcar.helper;

import racingcar.domain.Cars;
import racingcar.exception.ErrorMessages;

import java.util.Arrays;
import java.util.List;

public class PreparationHelper {

    public Cars createCars(String input) {
        List<String> carNames = splitCarNames(input);
        validateCarNumber(carNames);
        return new Cars(carNames);
    }

    public int createRound(String input) {
        validateRound(input);

        int round = Integer.parseInt(input);
        validatePositiveInt(round);
        return round;
    }

    private List<String> splitCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    private void validateCarNumber(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NUMBER);
        }
    }

    private void validateRound(String input) {
        validateRoundNumber(input);
        validateOverflow(input);
    }

    private void validateRoundNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ROUND_TYPE);
        }
    }

    private void validateOverflow(String input) {
        long temp = Long.parseLong(input);
        if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_RANGE_OF_INT);
        }
    }

    private void validatePositiveInt(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_RANGE_OF_NUMBERS);
        }
    }
}
