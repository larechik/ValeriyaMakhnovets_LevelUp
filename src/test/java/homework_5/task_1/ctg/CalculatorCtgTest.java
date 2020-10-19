package homework_5.task_1.ctg;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("trigonometry")
public class CalculatorCtgTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.ctg.CalculatorCtgDataProvider#positiveCtgData")
    public void ctgPositiveLongTests(double a, double result) {
        assertEquals(result, calc.ctg(a),0.00001);
    }

}
