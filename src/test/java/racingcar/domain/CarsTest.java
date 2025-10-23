package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @DisplayName("중복된 자동차 이름이 있는 경우 : 예외 발생")
    @Test
    void validateDuplicateNameTest() {
        // given
        List<String> names = List.of("pobi", "woni", "pobi");

        // when & then
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

    @DisplayName("전진 횟수가 가장 많은 우승자 반환 성공")
    @Test
    void successFindWinner() {
        // given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));

        for (int i = 0; i < 3; i++) cars.getCars().get(0).move();
        for (int i = 0; i < 7; i++) cars.getCars().get(1).move();
        for (int i = 0; i < 5; i++) cars.getCars().get(2).move();

        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners)
                .extracting(Car::getName)
                .containsExactly("woni");
    }

    @DisplayName("전진 횟수가 가장 많은 공동 우승자 반환 성공")
    @Test
    void successFindBothWinners() {
        // given
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));

        for (int i = 0; i < 3; i++) cars.getCars().get(0).move();
        for (int i = 0; i < 5; i++) cars.getCars().get(1).move();
        for (int i = 0; i < 5; i++) cars.getCars().get(2).move();

        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners)
                .extracting(Car::getName)
                .containsExactly("woni", "jun");
    }
}
