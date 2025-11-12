package assignments.colors.v3;

public enum Color {
    RED, GREEN, BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        try {
            if (colorString == null) {
                throw new ColorException(ColorErrorCode.NULL_COLOR);
            }
            return Color.valueOf(colorString);
        } catch (IllegalArgumentException e) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
    }
}
