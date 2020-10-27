package homework_5.task_1.cos;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorCosDataProvider {
    public static Stream<Arguments> positiveCosData() {
        return Stream.of(
                Arguments.of(0.0, 1.0),
                Arguments.of(Math.PI, -1),
                Arguments.of(-Math.PI, -1),
                Arguments.of(Math.PI/2, 0),
                Arguments.of(-Math.PI/2, 0)
        );
    }

}
