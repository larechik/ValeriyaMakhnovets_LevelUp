package homework_5.task_1.sub;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("subAndDiv")
public class CalculatorSubTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.sub.CalculatorSubDataProvider#positiveLongTestData")
    public void subPositiveLongTests(long a, long b, long result) {
        assertEquals(result, calc.sub(a, b));
    }

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.sub.CalculatorSubDataProvider#positiveDoubleTestData")
    public void subPositiveDoubleTests(double a, double b, double result) {
        assertEquals(result, calc.sub(a, b));
    }
}
