package homework_5.task_1.isNegative;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorIsNegativeTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.isNegative.CalculatorIsNegativeDataProvider#isNegativeData")
    public void powPositiveLongTests(long a, boolean result) {
        assertEquals(result, calc.isNegative(a));
    }

}
