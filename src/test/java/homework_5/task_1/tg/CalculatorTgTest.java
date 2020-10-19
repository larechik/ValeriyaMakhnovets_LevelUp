package homework_5.task_1.tg;

import homework_5.task_1.base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("trigonometry")
public class CalculatorTgTest extends BaseTest {

    @ParameterizedTest()
    @MethodSource("homework_5.task_1.tg.CalculatorTgDataProvider#positiveTgData")
    public void tgPositiveLongTests(double a, double result) {
        assertEquals(result, calc.tg(a),0.00001);
    }

}
