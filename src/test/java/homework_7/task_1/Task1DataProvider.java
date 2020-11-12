package homework_7.task_1;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Task1DataProvider {

    public static Stream<Arguments> letterData() {
        return Stream.of(
                Arguments.of("makhnovets1995@inbox.ru", "bla","blabla")
        );
    }
}
