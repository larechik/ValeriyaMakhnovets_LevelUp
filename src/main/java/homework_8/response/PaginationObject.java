package homework_8.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


public class PaginationObject {
    private long total;
    private long pages;
    private long page;
    private long limit;

    @Override
    public String toString() {
        return "PaginationObject{" +
                "total=" + total +
                ", pages=" + pages +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
