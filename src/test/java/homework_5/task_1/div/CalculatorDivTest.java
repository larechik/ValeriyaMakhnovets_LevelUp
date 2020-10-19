package homework_5.task_1.div;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("subAndDiv")
public class CalculatorDivTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.div.CalculatorDivDataProvider#positiveLongTestData")
    public void divPositiveLongTests(long a, long b, long result) {
        assertEquals(result, calc.div(a, b));
    }

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.div.CalculatorDivDataProvider#positiveDoubleTestData")
    public void divPositiveDoubleTests(Double a, Double b, Double result) {
        assertEquals(result, calc.div(a, b));
    }


    @ParameterizedTest()
    @MethodSource("homework_5.task_1.div.CalculatorDivDataProvider#numberFormatExceptionLongTestData")
    public void numberFormatExceptionLongTests(long a, long b) {
        assertThrows(NumberFormatException.class, () -> calc.div(a,b));

    }

}
