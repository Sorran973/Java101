package ru.artembulkhak.leetcode.others;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int left, right, top, bottom;
        left = top = 0;
        right = bottom = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }

            left++;
            top++;
            right--;
            bottom--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        new RotateImage().rotate(matrix);
    }
}
