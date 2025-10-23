package racingcar.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.*;

public class PreparationHelperTest {

    private PreparationHelper helper;

    @BeforeEach
    void setUp() {
        helper = new PreparationHelper();
    }

    @DisplayName("자동차 이름 쉼표 분리 성공")
    @Test
    void splitCarNamesTest() {
        // given
        String input = "pobi,woni,jun";

        // when
        Cars cars = helper.createCars(input);

        // then
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @DisplayName("입력된 자동차 개수가 1개 이하인 경우 : 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "pobi"})
    void validateCarNumberTest(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> helper.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("총 자동차의 개수는 2개 이상이어야 합니다.");
    }

    @DisplayName("시도 횟수 처리 성공")
    @ParameterizedTest
    @ValueSource(strings = {"  1", "2"})
    void successRoundTest(String input) {
        // given

        // when, then
        assertThatCode(() -> helper.createRound(input)).doesNotThrowAnyException();
    }

    @DisplayName("시도 횟수가 숫자 타입이 아닌 경우 : 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "pobi12"})
    void validateRoundTypeTest(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> helper.createRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @DisplayName("시도 횟수가 양수가 아닌 경우 : 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void validateRoundRangeTest(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> helper.createRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양수여야 합니다.");
    }

    @DisplayName("시도 횟수가 int 범위를 초과한 입력값인 경우 : 예외 발생")
    @Test
    void validateOverflowTest() {
        // given
        String input ="9999999999";

        // when, then
        assertThatThrownBy(() -> helper.createRound(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("int 범위를 초과한 입력값입니다.");
    }
}
