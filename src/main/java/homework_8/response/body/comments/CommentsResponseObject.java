package homework_8.response.body.comments;

import homework_8.response.BaseResponseObject;

import java.util.List;

public class CommentsResponseObject extends BaseResponseObject {
    private List<CommentObject> data;

    public List<CommentObject> getData() {
        return data;
    }

    public void setData(List<CommentObject> data) {
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
