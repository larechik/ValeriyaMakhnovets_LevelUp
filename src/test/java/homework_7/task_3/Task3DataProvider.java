package homework_7.task_3;

import homework_7.base.BaseTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Task3DataProvider {

    public static Stream<Arguments> letterData() {
        return Stream.of(
                Arguments.of(BaseTest.getLogin(), "bla","blabla")
        );
    }
}
