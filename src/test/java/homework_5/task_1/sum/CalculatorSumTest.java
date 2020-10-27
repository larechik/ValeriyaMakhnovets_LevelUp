package homework_5.task_1.sum;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

@Tag("sumAndMult")
public class CalculatorSumTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.sum.CalculatorSumDataProvider#positiveLongTestData")
    public void sumPositiveLongTests(long a, long b, long result) {
        assertEquals(result, calc.sum(a, b));
    }

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.sum.CalculatorSumDataProvider#positiveDoubleTestData")
    public void sumPositiveDoubleTests(double a, double b, double result) {
        assertEquals(result, calc.sum(a, b));
    }

}
