package assignments.matrix;

import java.util.*;

public class MatrixNonSimilarRows {

    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> uniqueRows = new LinkedHashMap<>();

        for (int[] row : matrix) {
            Set<Integer> setOfRowNumbers = new HashSet<>();
            for (int value : row) {
                setOfRowNumbers.add(value);
            }
            uniqueRows.putIfAbsent(setOfRowNumbers, row);
        }

        return new LinkedHashSet<>(uniqueRows.values());
    }
}
