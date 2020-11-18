package homework_8.comments;

import homework_8.response.body.comments.CommentObject;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Date;
import java.util.stream.Stream;

public class PostApiDataProvider {
    public static Stream<Arguments> setNewCommentsDataProvider() {
        return Stream.of(
                Arguments.of(createComment(42,"Lebowski","Lebowski@dude.com","The Big Lebowski"))
        );
    }

    private static CommentObject createComment(long postId, String name, String email, String body) {
        CommentObject comment = new CommentObject();
        comment.setPostId(postId);
        comment.setName(name);
        comment.setEmail(email);
        comment.setBody(body);
        return comment;
    }
}
