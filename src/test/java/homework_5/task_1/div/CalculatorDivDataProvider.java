package homework_5.task_1.div;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorDivDataProvider {
    public static Stream<Arguments> positiveLongTestData() {
        return Stream.of(
                Arguments.of(0L, 1L, 0L),
                Arguments.of(-1L, -1L, 1L),
                Arguments.of(1L, 1L, 1L),
                Arguments.of(1L, -1L, -1L),
                Arguments.of(-1L, 1L, -1L)
        );
    }

    public static Stream<Arguments> positiveDoubleTestData() {
        return Stream.of(
                Arguments.of(0.0, 0.0, Double.NaN),
                Arguments.of(1.0, 0.0, Double.POSITIVE_INFINITY),
                Arguments.of(-1.0, 0.0, Double.NEGATIVE_INFINITY),
                Arguments.of(0.0, 1.0, 0.0),
                Arguments.of(-1.0, -1.0, 1.0),
                Arguments.of(-1.0, 1.0, -1.0),
                Arguments.of(1.0, -1.0, -1.0),
                Arguments.of(1.0, 1.0, 1.0)
        );
    }

    public static Stream<Arguments> numberFormatExceptionLongTestData() {
        return Stream.of(
                Arguments.of(0L, 0L),
                Arguments.of(1L, 0L),
                Arguments.of(-1L, 0L)
        );
    }


}
