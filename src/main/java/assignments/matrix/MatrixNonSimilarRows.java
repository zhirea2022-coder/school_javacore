package assignments.matrix;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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

        return new HashSet<>(uniqueRows.values());
    }
}
