package homework_8.users;

import homework_8.response.body.people.Gender;
import homework_8.response.body.people.PeopleObject;
import homework_8.response.body.people.Status;
import homework_8.response.body.post.PostObject;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class PutApiDataProvider {
    public static Stream<Arguments> putUserDataProvider() {
        return Stream.of(
                Arguments.of(42,createUser("Jeffrey Lebowski",Gender.Male,Status.Active))
        );
    }

    private static PeopleObject createUser(String name, Gender gender, Status status) {
        PeopleObject user = new PeopleObject();
        user.setName(name);
        user.setGender(gender);
        user.setStatus(status);
        return user;
    }
}
