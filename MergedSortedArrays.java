package com.mindbottle;

public class MergeSortedArrays {

    public static void main(String args[]) {
        int[] a = new int[]{1,4,8};
        int[] b = new int[]{2,5,6,9,10,11,12};

        int[] result = MergeSortedArrays(a,b);

        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] MergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int aIndex=0, bIndex=0, resultIndex=0;

        // copy the smaller number from array a or array b
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] > b[bIndex]) {
                result[resultIndex] = b[bIndex];
                bIndex++;
            } else {
                result[resultIndex] = a[aIndex];
                aIndex++;
            }
            resultIndex++;
        }
        
        // copy any left over from arrays 
        while (aIndex < a.length) {
            result[resultIndex] = a[aIndex];
            aIndex++;
            resultIndex++;
        }

        while (bIndex < b.length) {
            result[resultIndex] = b[bIndex];
            bIndex++;
            resultIndex++;
        }
        return result;
    }
}

