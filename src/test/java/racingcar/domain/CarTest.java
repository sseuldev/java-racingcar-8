package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("자동차 이름 중 빈 문자열이 있는 경우 : 예외 발생")
    @Test
    void validateNameEmptyTest() {
        // given
        List<String> names = List.of("", "woni", "pobi");

        // when & then
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열 일 수 없습니다.");
    }

    @DisplayName("자동차 이름 중 6자 이상이 있는 경우 : 예외 발생")
    @Test
    void validateNameLengthTest() {
        // given
        List<String> names = List.of("alizabeth", "woni", "pobi");

        // when & then
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }
}
