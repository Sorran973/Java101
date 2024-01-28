package ru.artembulkhak.leetcode;


public class RotateImageEasy {

    public static int[][] rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int[] arrayToMatrix = new int[matrix[0].length];
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                arrayToMatrix[matrix[0].length - 1 - j] = matrix[j][i];
            }

            newMatrix[i] = arrayToMatrix;
        }

        return newMatrix;
    }

    public static int[][] rotate(int[][] matrix, int angle) {
        int[][] newMatrix = matrix;

        for (int k = 0; k < angle; k++) {
            newMatrix = rotate(newMatrix);
        }

        return newMatrix;
    }

    public static void main(String[] args) {

        int[][] matrix = matrix = new int[][] {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}};

        int[][] matrixOnce = rotate(matrix, 1);
        int[][] matrixTwice = rotate(matrix, 2);
        int[][] matrixThird = rotate(matrix, 3);

    }
}
