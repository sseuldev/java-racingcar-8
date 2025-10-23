package racingcar.exception;

public final class ErrorMessages {

    public static final String INVALID_CAR_NUMBER = "총 자동차의 개수는 2개 이상이어야 합니다.";
    public static final String DUPLICATED_CAR_NAME = "중복된 자동차 이름이 존재합니다.";
    public static final String INVALID_CAR_NAME_EMPTY = "자동차 이름은 빈 문자열 일 수 없습니다.";
    public static final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";
    public static final String INVALID_ROUND_TYPE = "시도 횟수는 숫자여야 합니다.";
    public static final String INVALID_RANGE_OF_NUMBERS = "시도 횟수는 양수여야 합니다.";
    public static final String INVALID_RANGE_OF_INT = "int 범위를 초과한 입력값입니다.";

    private ErrorMessages() {}
}
