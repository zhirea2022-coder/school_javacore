package assignments.ttschool;

public enum TrainingErrorCode {

    TRAINEE_WRONG_FIRSTNAME("TRAINEE_WRONG_FIRSTNAME"),
    TRAINEE_WRONG_LASTNAME("TRAINEE_WRONG_LASTNAME"),
    TRAINEE_WRONG_RATING("TRAINEE_WRONG_RATING"),
    TRAINEE_NOT_FOUND("TRAINEE_NOT_FOUND"),
    EMPTY_TRAINEE_QUEUE("EMPTY_TRAINEE_QUEUE"),
    DUPLICATE_TRAINEE("DUPLICATE_TRAINEE"),
    GROUP_WRONG_NAME("GROUP_WRONG_NAME"),
    GROUP_WRONG_ROOM("GROUP_WRONG_ROOM"),
    GROUP_NOT_FOUND("GROUP_NOT_FOUND"),
    DUPLICATE_GROUP_NAME("DUPLICATE_GROUP_NAME"),
    SCHOOL_WRONG_NAME("SCHOOL_WRONG_NAME");

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    private String errorString;

    public String getErrorString() {
        return errorString;
    }
}
