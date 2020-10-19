package homework_5.task_1.cos;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("trigonometry")
public class CalculatorCosTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.cos.CalculatorCosDataProvider#positiveCosData")
    public void cosPositiveLongTests(double a, double result) {
        assertEquals(result, calc.cos(a),0.00001);
    }

}
