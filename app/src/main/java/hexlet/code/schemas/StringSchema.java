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

    public StringSchema contains(String substring) {
        isContains = true;
        this.substring = substring;
        return this;
    }

    public StringSchema required() {
        isReq = true;
        return this;
    }

    public StringSchema minLength(int reqLength) {
        isMinLength = true;
        this.reqLength = reqLength;
        return this;
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
