package homework_8.posts;

import homework_8.response.body.comments.CommentObject;
import homework_8.response.body.post.PostObject;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PostApiDataProvider {
    public static Stream<Arguments> setNewPostDataProvider() {
        return Stream.of(
                Arguments.of(createPost(42,"The Big Lebowski",
                        "The Big Lebowski is a 1998 crime comedy film written, produced, and directed by Joel and Ethan Coen."))
        );
    }

    private static PostObject createPost(long userId, String title, String body) {
       PostObject post = new PostObject();
       post.setUserId(userId);
       post.setTitle(title);
       post.setBody(body);
        return post;
    }
}
