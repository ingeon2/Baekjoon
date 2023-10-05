class Solution {
    public String solution(String my_string) {
        char[] arr1 = my_string.toCharArray();
        char[] arr2 = new char[arr1.length];
        for(int i = 0 ; i < arr1.length ; i++) {
            arr2[i] = arr1[arr1.length - 1 - i];
        }
        return new String (arr2);
    }
}