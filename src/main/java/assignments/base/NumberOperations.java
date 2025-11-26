package assignments.base;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberOperations {

    public static Integer find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return null;
    }

    public static Integer find(double[] array, double value, double eps) {
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps) {
                return i;
            }
        }
        return null;
    }

    public static Double calculateDensity(double weight, double volume, double min, double max) {
        if (volume == 0) {
            return null;
        }
        Double density = weight / volume;
        if (density >= min && density <= max) {
            return density;
        }
        return null;
    }

    public static Integer find(BigInteger[] array, BigInteger value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return null;
    }


    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        if (volume.compareTo(BigDecimal.ZERO) == 0) {
            return null;
        }
        BigDecimal density = weight.divide(volume, 2, BigDecimal.ROUND_HALF_UP);
        if (density.compareTo(min) >= 0 && density.compareTo(max) <= 0) {
            return density.setScale(1, BigDecimal.ROUND_HALF_UP);
        }
        return null;
    }
}
