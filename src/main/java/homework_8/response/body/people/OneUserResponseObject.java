package homework_8.response.body.people;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import homework_8.response.BaseResponseObject;

import java.util.List;

public class OneUserResponseObject extends BaseResponseObject {

    private PeopleObject data;

    public PeopleObject getData() {
        return data;
    }

    public void setData(PeopleObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PeopleResponseObject{" +
                "data=" + data +
                ", code=" + code +
                ", number=" + number +
                ", meta=" + meta +
                '}';
    }
}
