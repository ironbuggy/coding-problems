package com.mindbottle;

/**
 *  Write a function to compute the maximum length palindromic sub-sequence of an array.
 *  A palindrome is a sequence which is equal to its reverse.
 *  A sub-sequence of an array is a sequence which can be constructed by removing elements of the array.
 *  Ex: Given [4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4] should return 10 (all 4's)
 */
public class MaxLengthPalindrome {

    public static void main(String[] args) {
        // Note: Array initialisation
        int[] nums = new int[]{1, 2, 3, 2, 1, 6, 1, 2, 3, 2};

        System.out.println(MaxLengthPalindrome(nums));
    }

    // O(N2) runtime and O(N2) space
    public static int MaxLengthPalindrome(int[] values) {
        int n = values.length;
        int maxlen=1;
        int startIndex=0;

        // Note: 2d array
        boolean table[][] = new boolean[n][n];

        // length = 1, always true
        for (int i=0; i<n; i++) {
            table[i][i] = true;
        }

        // length = 2
        for (int i=0; i<n-1; i++) {
            // palindrome!
            if(values[i] == values[i+1]) {
                table[i][i+1] = true;
                startIndex = i;
                maxlen = 2;
            }
        }

        // length >= 3
        for (int len=3; len<=n; len++) {
            for (int i=0; i<n-len+1; i++) {
                int j = i+len-1;
                // current two chars are the same, one left is also palindrome
                if (values[i] == values[j] && table[i+1][j-1]) {
                    table[i][j]=true;
                    startIndex=i;
                    maxlen=len;
                }
            }
        }

        for (int i=0; i<values.length; i++) {
            if (i>=startIndex && i<=(startIndex+maxlen)) {
                System.out.print(values[i]);
            }
        }
        System.out.println();

        return maxlen;
    }
}

