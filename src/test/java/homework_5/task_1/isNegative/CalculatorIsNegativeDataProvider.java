package homework_5.task_1.isNegative;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorIsNegativeDataProvider {


    public static Stream<Arguments> isNegativeData() {
        return Stream.of(
                Arguments.of(1L, false),
                Arguments.of(-1L, true),
                Arguments.of(0L, false)
        );
    }

}
