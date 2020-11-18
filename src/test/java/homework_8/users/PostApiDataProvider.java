package homework_8.users;

import homework_8.response.body.comments.CommentObject;
import homework_8.response.body.people.Gender;
import homework_8.response.body.people.PeopleObject;
import homework_8.response.body.people.Status;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PostApiDataProvider {
    public static Stream<Arguments> createUserDataProvider() {
        return Stream.of(
                Arguments.of(createUser("Jeffrey Lebowski",Gender.Male,"Lebowski@dude.com",Status.Active))
        );
    }

    private static PeopleObject createUser(String name, Gender gender, String email, Status status) {
        PeopleObject user = new PeopleObject();
        user.setName(name);
        user.setGender(gender);
        user.setEmail(email);
        user.setStatus(status);
        return user;
    }
}
