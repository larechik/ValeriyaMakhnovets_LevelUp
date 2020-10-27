package homework_5.task_1.tg;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorTgDataProvider {
    public static Stream<Arguments> positiveTgData() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(Math.PI/4, 1.0),
                Arguments.of(-Math.PI/4, -1.0),
                Arguments.of(Math.PI/2, Double.POSITIVE_INFINITY),
                Arguments.of(-Math.PI/2, Double.NEGATIVE_INFINITY)
        );
    }

}
