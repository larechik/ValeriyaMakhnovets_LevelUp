package homework_8.response;

public class MetaObject {
    protected PaginationObject pagination;

    public PaginationObject getPagination() {
        return pagination;
    }

    public void setPagination(PaginationObject pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "MetaObject{" +
                "pagination=" + pagination +
                '}';
    }
}
