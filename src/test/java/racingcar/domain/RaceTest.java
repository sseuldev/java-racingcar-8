package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.helper.RandomNumberHelper;
import racingcar.helper.TestRandomNumberHelper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RaceTest {

    @DisplayName("랜덤값이 4 이상이면 자동차 이동")
    @Test
    void isMovableSuccess() {
        // given
        Cars cars = new Cars(List.of("pobi"));
        RandomNumberHelper randomNumberHelper = new TestRandomNumberHelper(4);
        Race race = new Race(cars, randomNumberHelper);

        // when
        race.decideMove();

        // then
        assertThat(cars.getCars().getFirst().getDistance()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 3 이하면 자동차 정지")
    @Test
    void notMovableSuccess() {
        // given
        Cars cars = new Cars(List.of("pobi"));
        RandomNumberHelper randomNumberHelper = new TestRandomNumberHelper(1);
        Race race = new Race(cars, randomNumberHelper);

        // when
        race.decideMove();

        // then
        assertThat(cars.getCars().getFirst().getDistance()).isZero();
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차 우승자 반환 성공")
    void successDecideWinners() {
        // given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));

        for (int i = 0; i < 3; i++) cars.getCars().get(0).move();
        for (int i = 0; i < 5; i++) cars.getCars().get(1).move();
        for (int i = 0; i < 5; i++) cars.getCars().get(2).move();

        RandomNumberHelper randomNumberHelper = new TestRandomNumberHelper(0);
        Race race = new Race(cars, randomNumberHelper);

        // when
        List<Car> winners = race.decideWinner();

        // then
        assertThat(winners)
                .extracting(Car::getName)
                .containsExactly("woni", "jun");
    }
}
