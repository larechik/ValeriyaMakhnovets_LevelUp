package homework_8.response.body.people;

import homework_8.response.BaseResponseObject;

import java.util.List;

public class PeopleResponseObject extends BaseResponseObject {

    private List<PeopleObject> data;

    public List<PeopleObject> getData() {
        return data;
    }

    public void setData(List<PeopleObject> data) {
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
