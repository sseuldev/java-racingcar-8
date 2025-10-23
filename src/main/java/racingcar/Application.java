package racingcar;

import racingcar.config.RacingConfig;
import racingcar.controller.RacingController;
import racingcar.controller.ReadyController;
import racingcar.domain.Race;
import racingcar.helper.PreparationHelper;
import racingcar.helper.RandomNumberHelper;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        PreparationHelper preparationHelper = new PreparationHelper();
        RandomNumberHelper randomNumberHelper = new RandomNumberHelper();

        ReadyController readyController = new ReadyController(inputView, preparationHelper);
        RacingConfig racingConfig = readyController.ready();

        Race race = new Race(racingConfig.cars(), randomNumberHelper);

        RacingController racingController = new RacingController(outputView, racingConfig, race);
        racingController.start();
    }
}
