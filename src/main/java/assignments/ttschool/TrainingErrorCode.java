package assignments.ttschool;

public enum TrainingErrorCode {

    TRAINEE_WRONG_FIRSTNAME("TRAINEE_WRONG_FIRSTNAME"),
    TRAINEE_WRONG_LASTNAME("TRAINEE_WRONG_LASTNAME"),
    TRAINEE_WRONG_RATING("TRAINEE_WRONG_RATING");

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    private String errorString;

    public String getErrorString() {
        return errorString;
    }
}
