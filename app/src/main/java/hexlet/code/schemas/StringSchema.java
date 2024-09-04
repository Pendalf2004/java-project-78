package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema {

    private boolean isContains = false;
    private boolean isMinLength = false;
    private boolean isReq = false;
    private String substring;
    private int reqLength;

    public StringSchema() {
    }

    public void contains(String substring) {
        isContains = true;
        this.substring = substring;
    }

    public void required() {
        isReq = true;
    }

    public void minLength(int reqLength) {
        isMinLength = true;
        this.reqLength = reqLength;
    }

    public boolean isValid(Object item) {
        if (Objects.isNull(item)) {
            return !isReq;
        }

        if (isContains && !item.toString().contains(substring)) {
            return false;
        }
        if (isReq && item.toString().isEmpty()) {
            return false;
        }
        if (isMinLength && (item.toString().length() < reqLength)) {
            return false;
        }
        return true;
    }
    public boolean isValid() {
        return isValid(null);
    }
}
