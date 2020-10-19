package homework_5.task_1.ctg;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorCtgDataProvider {
    public static Stream<Arguments> positiveCtgData() {
        return Stream.of(
                Arguments.of(0.0, Double.POSITIVE_INFINITY),
                Arguments.of(Math.PI, Double.POSITIVE_INFINITY),
                Arguments.of(Math.PI/4, 1.0),
                Arguments.of(-Math.PI/4, -1.0),
                Arguments.of(Math.PI/2, 0),
                Arguments.of(-Math.PI/2, 0)
        );
    }

}
