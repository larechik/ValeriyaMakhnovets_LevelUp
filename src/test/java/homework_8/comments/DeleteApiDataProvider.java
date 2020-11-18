package homework_8.comments;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DeleteApiDataProvider {
    public static Stream<Arguments> deleteComment() {
        return Stream.of(
                Arguments.of(51)
        );
    }
}
