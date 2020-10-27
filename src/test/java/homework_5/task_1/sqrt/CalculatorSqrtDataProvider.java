package homework_5.task_1.sqrt;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorSqrtDataProvider {


    public static Stream<Arguments> positiveSqrtData() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(-1.0, 1.0),
                Arguments.of(1.0, 1.0),
                Arguments.of(4.0, 2.0),
                Arguments.of(-4.0, 2.0),
                Arguments.of(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
                Arguments.of(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
        );
    }

}
