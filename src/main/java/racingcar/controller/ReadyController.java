package racingcar.controller;

import racingcar.config.RacingConfig;
import racingcar.domain.Cars;
import racingcar.helper.PreparationHelper;
import racingcar.view.InputView;

public class ReadyController {

    private final InputView inputView;
    private final PreparationHelper preparationHelper;

    public ReadyController(InputView inputView, PreparationHelper preparationHelper) {
        this.inputView = inputView;
        this.preparationHelper = preparationHelper;
    }

    public RacingConfig ready() {
        String carsInput = inputView.readCarsInput();
        String roundInput = inputView.readRoundInput();

        Cars cars = preparationHelper.createCars(carsInput);
        int round = preparationHelper.createRound(roundInput);

        return new RacingConfig(cars, round);
    }
}
