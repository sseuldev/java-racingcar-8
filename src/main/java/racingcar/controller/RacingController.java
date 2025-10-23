package racingcar.controller;

import racingcar.config.RacingConfig;
import racingcar.domain.Race;
import racingcar.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final RacingConfig config;
    private final Race race;

    public RacingController(OutputView outputView, RacingConfig config, Race race) {
        this.outputView = outputView;
        this.config = config;
        this.race = race;
    }

    public void start() {
        outputView.showResultOutput();
        for (int i = 0; i < config.rounds(); i++) {
            race.decideMove();
            outputView.showRoundOutput(config.cars().getCars());
        }
        outputView.showWinnerOutput(race.decideWinner());
    }
}
