package homework_5.task_1.sin;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("trigonometry")
public class CalculatorSinTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.sin.CalculatorSinDataProvider#positiveSinData")
    public void sinPositiveLongTests(double a, double result) {
        assertEquals(result, calc.sin(a),0.00001);
    }

}
