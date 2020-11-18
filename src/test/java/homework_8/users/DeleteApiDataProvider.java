package homework_8.users;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DeleteApiDataProvider {
    public static Stream<Arguments> deleteOneUser() {
        return Stream.of(
                Arguments.of(51)
        );
    }
}
