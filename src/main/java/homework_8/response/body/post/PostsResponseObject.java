package homework_8.response.body.post;

import homework_8.response.BaseResponseObject;
import homework_8.response.body.comments.CommentObject;

import java.util.List;

public class PostsResponseObject extends BaseResponseObject {
    private List<PostObject> data;

    public List<PostObject> getData() {
        return data;
    }

    public void setData(List<PostObject> data) {
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
