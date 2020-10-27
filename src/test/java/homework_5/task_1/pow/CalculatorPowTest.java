package homework_5.task_1.pow;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorPowTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.pow.CalculatorPowDataProvider#positivePowData")
    public void powPositiveLongTests(double a, double b, double result) {
        assertEquals(result, calc.pow(a, b));
    }

}
