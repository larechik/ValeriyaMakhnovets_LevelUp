package homework_8.posts;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class GetApiDataProvider {

    public static Stream<Arguments> getOneUser() {
        return Stream.of(
                Arguments.of(42)
        );
    }
}
