class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for(int r = 0 ; r < arr1.length ; r++) {
            for(int c = 0 ; c < arr1[0].length ; c++) {
                arr1[r][c] += arr2[r][c];
            }
        }
        return arr1;
    }
}