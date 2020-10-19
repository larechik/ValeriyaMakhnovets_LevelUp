package homework_5.task_1.pow;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorPowDataProvider {


    public static Stream<Arguments> positivePowData() {
        return Stream.of(
                Arguments.of(0.0, 0.0, 1.0),
                Arguments.of(0.0, 2.0, 0.0),
                Arguments.of(2.0, 1.0, 2.0),
                Arguments.of(2.0, 2.0, 4.0),
                Arguments.of(2.0, -1.0, 0.5),
                Arguments.of(2.0, Double.MAX_VALUE, Double.POSITIVE_INFINITY),
                Arguments.of(Double.MAX_VALUE, 2.0,Double.POSITIVE_INFINITY),
                Arguments.of(-2.0, 2.0, 4.0),
                Arguments.of(-2.0, 3.0, -8.0)
        );
    }

}
