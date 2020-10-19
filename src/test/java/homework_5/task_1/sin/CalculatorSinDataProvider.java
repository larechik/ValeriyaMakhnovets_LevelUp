package homework_5.task_1.sin;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorSinDataProvider {
    public static Stream<Arguments> positiveSinData() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(Math.PI, 0.0),
                Arguments.of(Math.PI/2, 1.0),
                Arguments.of(-Math.PI/2, -1.0)
        );
    }

}
