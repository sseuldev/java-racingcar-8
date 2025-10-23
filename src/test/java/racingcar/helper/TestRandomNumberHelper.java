package racingcar.helper;

public class TestRandomNumberHelper extends RandomNumberHelper {

    private final int fixedValue;

    public TestRandomNumberHelper(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}
