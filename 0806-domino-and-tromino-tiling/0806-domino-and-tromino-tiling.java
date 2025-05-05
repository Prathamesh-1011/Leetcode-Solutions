class Solution {
    private static final long MODULO = 1_000_000_007;

    private long[][] multiplyMatrices(long[][] matrixA, long[][] matrixB) {
        long[][] result = new long[4][4];
        for (int row = 0; row < 4; ++row) {
            for (int col = 0; col < 4; ++col) {
                if (matrixA[row][col] != 0) {
                    for (int k = 0; k < 4; ++k) {
                        if (matrixB[col][k] != 0) {
                            result[row][k] = (result[row][k] + matrixA[row][col] * matrixB[col][k] % MODULO) % MODULO;
                        }
                    }
                }
            }
        }
        return result;
    }

    public int numTilings(int tiles) {
        long[][] baseMatrix = {
            {0, 1, 0, 1},
            {1, 1, 0, 1},
            {0, 2, 0, 1},
            {0, 0, 1, 0}
        };

        long[][] identityMatrix = new long[4][4];
        for (int i = 0; i < 4; ++i) identityMatrix[i][i] = 1;

        while (tiles > 0) {
            if ((tiles & 1) == 1) identityMatrix = multiplyMatrices(identityMatrix, baseMatrix);
            baseMatrix = multiplyMatrices(baseMatrix, baseMatrix);
            tiles >>= 1;
        }

        return (int) identityMatrix[1][1];
    }
}
