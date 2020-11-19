package homework_8.response.body.comments;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CommentObject {
    private long id;

    @JsonProperty("post_id")
    private long postId;

    private String name;

    private String email;

    private String body;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @Override
    public String toString() {
        return "CommentObject{" +
                "id=" + id +
                ", postId=" + postId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentObject)) return false;
        CommentObject that = (CommentObject) o;
        return getPostId() == that.getPostId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getBody(), that.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostId(), getName(), getEmail(), getBody());
    }
}
