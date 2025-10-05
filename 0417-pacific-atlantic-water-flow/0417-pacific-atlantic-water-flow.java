import java.util.*;

class Solution {

    List<List<Integer>> pacificAtlantic(int[][] heightMap) {
        return new AbstractList<List<Integer>>() {
            private List<List<Integer>> result;

            @Override
            public List<Integer> get(int index) {
                initialize();
                return result.get(index);
            }

            @Override
            public int size() {
                initialize();
                return result.size();
            }

            private void initialize() {
                if (result == null) {
                    result = computeFlow(heightMap);
                }
            }
        };
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private List<List<Integer>> computeFlow(int[][] heightMap) {
        List<List<Integer>> result = new ArrayList<>();
        if (heightMap == null || heightMap.length == 0) {
            return result;
        }

        int numRows = heightMap.length;
        int numCols = heightMap[0].length;
        char[][] oceanVisited = new char[numRows][numCols];

        // DFS from Pacific edges (top & left)
        for (int col = 0; col < numCols; col++) {
            dfs(heightMap, 0, col, oceanVisited, 'P', result);
        }
        for (int row = 0; row < numRows; row++) {
            dfs(heightMap, row, 0, oceanVisited, 'P', result);
        }

        // DFS from Atlantic edges (bottom & right)
        for (int col = 0; col < numCols; col++) {
            dfs(heightMap, numRows - 1, col, oceanVisited, 'A', result);
        }
        for (int row = 0; row < numRows; row++) {
            dfs(heightMap, row, numCols - 1, oceanVisited, 'A', result);
        }

        return result;
    }

    private void dfs(int[][] heightMap, int row, int col, char[][] oceanVisited, char ocean, List<List<Integer>> result) {
        // If this cell was already visited by the other ocean, add to result
        if (oceanVisited[row][col] == 'P' && ocean == 'A') {
            result.add(Arrays.asList(row, col));
        }

        oceanVisited[row][col] = ocean;

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < heightMap.length &&
                newCol >= 0 && newCol < heightMap[0].length &&
                heightMap[row][col] <= heightMap[newRow][newCol] &&
                oceanVisited[newRow][newCol] != ocean) {

                dfs(heightMap, newRow, newCol, oceanVisited, ocean, result);
            }
        }
    }
}