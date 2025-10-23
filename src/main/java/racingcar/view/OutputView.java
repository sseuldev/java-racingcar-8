package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String MOVE_UNIT = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void showResultOutput() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showRoundOutput(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + MOVE_UNIT.repeat(car.getDistance()));
        }
        System.out.print("\n");
    }

    public void showWinnerOutput(List<Car> winners) {
        String winnerName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(WINNER_MESSAGE + winnerName);
    }
}
