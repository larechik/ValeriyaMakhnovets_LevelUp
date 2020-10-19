package homework_5.task_1.base;

import org.junit.jupiter.api.BeforeAll;
import ru.levelup.qa.at.calculator.Calculator;

public class BaseTest {
    public static Calculator calc;

    @BeforeAll
    public static void setUp(){
        calc = new Calculator();
    }

}
