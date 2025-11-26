package assignments.base;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int totalLength = 0;
        if (strings != null) {
            for (String str : strings) {
                totalLength += (str != null) ? str.length() : 0; // Handle null strings
            }
        }
        return totalLength;
    }

    public static String getFirstAndLastLetterString(String string) {
        if (string == null || string.isEmpty()) return "";
        return string.charAt(0) + String.valueOf(string.charAt(string.length() - 1));
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return (string1 != null && string2 != null) &&
                (index >= 0 && index < string1.length() && index < string2.length()) &&
                (string1.charAt(index) == string2.charAt(index));
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return (string1 != null && string2 != null) &&
                (string1.indexOf(character) == string2.indexOf(character));
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return (string1 != null && string2 != null) &&
                (string1.lastIndexOf(character) == string2.lastIndexOf(character));
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return (string1 != null && string2 != null) &&
                (string1.indexOf(str) == string2.indexOf(str));
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return (string1 != null && string2 != null) &&
                (string1.lastIndexOf(str) == string2.lastIndexOf(str));
    }

    public static boolean isEqual(String string1, String string2) {
        return string1 != null && string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1 != null && string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1 != null && string2 != null && string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1 != null && string2 != null && string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return (string1 != null ? string1 : "") + (string2 != null ? string2 : "");
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return (string1 != null && string2 != null && prefix != null) &&
                string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return (string1 != null && string2 != null && suffix != null) &&
                string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        if (string1 == null || string2 == null) return "";
        int minLength = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minLength; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return string1.substring(0, i);
            }
        }
        return string1.substring(0, minLength);
    }

    public static String reverse(String string) {
        return string == null ? null : new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string != null && string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string != null && string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longest = "";
        if (strings != null) {
            for (String str : strings) {
                if (isPalindromeIgnoreCase(str) && str.length() > longest.length()) {
                    longest = str;
                }
            }
        }
        return longest;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (string1 == null || string2 == null || index < 0 || length < 0 ||
                index + length > string1.length() || index + length > string2.length()) {
            return false;
        }
        return string1.substring(index, index + length).equals(string2.substring(index, index + length));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2) {
        if (string1 == null || string2 == null) return false;
        string1 = string1.replace(replaceInStr1, replaceByInStr1);
        string2 = string2.replace(replaceInStr2, replaceByInStr2);
        return string1.equals(string2);
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2) {
        if (string1 == null || string2 == null) return false;
        string1 = string1.replace(replaceInStr1, replaceByInStr1);
        string2 = string2.replace(replaceInStr2, replaceByInStr2);
        return string1.equals(string2);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        if (string == null) return false;
        String cleanedString = string.replace(" ", "").toLowerCase();
        return isPalindromeIgnoreCase(cleanedString);
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1 != null && string2 != null && string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        if (array == null || array.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        if (array == null || array.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return new StringBuilder(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder result = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            if (positions[i] >= 0 && positions[i] < result.length()) {
                result.deleteCharAt(positions[i]);
            }
        }
        return result;
    }

    public static String insertCharacters(String original, int[] indices, char[] chars) {
        if (indices.length != chars.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }
        StringBuilder result = new StringBuilder(original);
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i] + i;
            result.insert(index, chars[i]);
        }
        return result.toString();
    }
}