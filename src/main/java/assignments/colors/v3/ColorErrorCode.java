package assignments.colors.v3;

public enum ColorErrorCode {

    WRONG_COLOR_STRING("WRONG_COLOR_STRING"),
    NULL_COLOR("NULL_COLOR");

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    private String errorString;

    public String getErrorString() {
        return errorString;
    }
}
