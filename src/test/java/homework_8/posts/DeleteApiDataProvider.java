package homework_8.posts;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DeleteApiDataProvider {
    public static Stream<Arguments> deletePosts() {
        return Stream.of(
                Arguments.of(51)
        );
    }
}
