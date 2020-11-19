package homework_8.response.body.comments;

import homework_8.response.BaseResponseObject;
import homework_8.response.body.people.PeopleObject;

public class CommentResponseObject extends BaseResponseObject {
    private CommentObject data;

    public CommentObject getData() {
        return data;
    }

    public void setData(CommentObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OneCommentResponseObject{" +
                "data=" + data +
                ", code=" + code +
                ", number=" + number +
                ", meta=" + meta +
                '}';
    }
}
