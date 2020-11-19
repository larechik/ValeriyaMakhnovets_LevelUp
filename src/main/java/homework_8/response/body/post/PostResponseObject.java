package homework_8.response.body.post;

import homework_8.response.BaseResponseObject;
import homework_8.response.body.comments.CommentObject;

public class PostResponseObject extends BaseResponseObject {
    private PostObject data;

    public PostObject getData() {
        return data;
    }

    public void setData(PostObject data) {
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
