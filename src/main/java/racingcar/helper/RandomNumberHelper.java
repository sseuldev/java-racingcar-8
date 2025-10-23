package racingcar.helper;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberHelper {

    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);
    }
}
