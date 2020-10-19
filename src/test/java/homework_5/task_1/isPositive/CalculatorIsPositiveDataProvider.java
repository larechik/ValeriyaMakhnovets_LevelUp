package homework_5.task_1.isPositive;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CalculatorIsPositiveDataProvider {


    public static Stream<Arguments> isPositiveData() {
        return Stream.of(
                Arguments.of(1L, true),
                Arguments.of(-1L, false),
                Arguments.of(0L, true)
        );
    }

}
