package homework_8.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import homework_8.response.body.people.PeopleObject;

public class BaseResponseObject {

    protected long code;
    protected long number;

    protected MetaObject meta;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public MetaObject getMeta() {
        return meta;
    }

    public void setMeta(MetaObject meta) {
        this.meta = meta;
    }
}
