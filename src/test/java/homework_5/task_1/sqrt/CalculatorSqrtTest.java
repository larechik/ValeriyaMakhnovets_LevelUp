package homework_5.task_1.sqrt;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorSqrtTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.sqrt.CalculatorSqrtDataProvider#positiveSqrtData")
    public void sqrtPositiveLongTests(double a, double result) {
        assertEquals(result, calc.sqrt(a));
    }

}
