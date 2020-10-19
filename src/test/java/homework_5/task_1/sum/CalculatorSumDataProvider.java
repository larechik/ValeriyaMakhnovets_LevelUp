package homework_5.task_1.sum;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorSumDataProvider {
    public static Stream<Arguments> positiveLongTestData() {
        return Stream.of(
                Arguments.of(0L, 0L, 0L),
                Arguments.of(-1L, -1L, -2L),
                Arguments.of(1L, 1L, 2L),
                Arguments.of(1L, -1L, 0L),
                Arguments.of(-1L, 1L, 0L)
        );
    }

    public static Stream<Arguments> positiveDoubleTestData() {
        return Stream.of(
                Arguments.of(0.0, 0.0, 0.0),
                Arguments.of(-1.0, -1.0, -2.0),
                Arguments.of(-1.0, 1.0, 0.0),
                Arguments.of(1.0, -1.0, 0.0),
                Arguments.of(1.0, 1.0, 2.0)
        );
    }

}
