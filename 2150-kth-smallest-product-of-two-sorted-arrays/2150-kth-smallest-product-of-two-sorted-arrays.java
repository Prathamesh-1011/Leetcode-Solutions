class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int segregated1[][] = segregate(nums1);
        int neg1[] = segregated1[0];
        int pos1[] = segregated1[1];
        int segregated2[][] = segregate(nums2);
        int neg2[] = segregated2[0];
        int pos2[] = segregated2[1];
        
        long negProd = (long) neg1.length * pos2.length + (long) pos1.length * neg2.length;

        int arr1[], arr2[], arr3[], arr4[];
        if(k <= negProd) {
            reverse(pos1);
            reverse(pos2);
            arr1 = neg1;
            arr2 = pos2;
            arr3 = neg2;
            arr4 = pos1;
        } else {
            k -= negProd;
            reverse(neg1);
            reverse(neg2);
            inverse(neg1);
            inverse(neg2);
            arr1 = neg1;
            arr2 = neg2;
            arr3 = pos1;
            arr4 = pos2;
        }
        long start = (long) -1e10, end = (long) 1e10;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            long count = countSmallerEqual(arr1, arr2, mid) + countSmallerEqual(arr3, arr4, mid);
            if(count < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private long countSmallerEqual(int A[], int B[], long num) {
        int i = 0, j = B.length - 1;
        long count = 0;
        while(i < A.length && j >= 0) {
            if(num < (long) A[i] * B[j]) {
                j--;
            } else {
                count += j + 1;
                i++;
            }
        }
        return count;
    }

    private void inverse(int nums[]) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
    }

    private void reverse(int nums[]) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private int[][] segregate(int nums[]) {
        ArrayList<Integer> negatives = new ArrayList<>(); 
        ArrayList<Integer> positives = new ArrayList<>(); 
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                negatives.add(nums[i]);
            } else {
                positives.add(nums[i]);
            }
        }
        int[] negativeArray = negatives.stream().mapToInt(i -> i).toArray();
        int[] positiveArray = positives.stream().mapToInt(i -> i).toArray();
        return new int[][]{negativeArray, positiveArray};
    }
}